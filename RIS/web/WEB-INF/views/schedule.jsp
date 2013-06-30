<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head />

<link rel='stylesheet' type='text/css' href='/RIS/static/css/fullcalendar' />
<script type='text/javascript' src='/RIS/static/js/jqueryui'></script>
<script type='text/javascript' src='/RIS/static/js/cookie'></script>
<script type='text/javascript' src='/RIS/static/js/fullcalendar'></script>
<title>Schedule</title>
<link rel= "stylesheet" href="/RIS/static/css/addpatient-style" >
</head>
<body>
	<script type="text/javascript">

		$(document).ready(function() {
			
            var date = new Date();
            var d = date.getDate();
            var m = date.getMonth();
            var y = date.getFullYear();
            /* var json = $.getJSON( "/RIS/static/json/resources", function() {
            	  console.log( "success" );
            	}); */
            var url = "/RIS/schedule/getResources";
            var url2 = "/RIS/schedule/getEvents";	
           var json = $.ajax({
            	            url: url,
            	            
            	            async: false,
            	            dataType: 'script'
            	        }).responseText;
            json = json.replace(/&quot;/gi, "\"");
            console.log( json );
            
            var eventsJson = $.ajax({
	            url: url2, 
	            async: false,
	            dataType: 'json'
	        }).responseText;
            eventsJson = eventsJson.replace(/&quot;/gi, "\"");
			console.log( eventsJson );
            
            var calendar = $("#calendar").fullCalendar({
                header: {
                    left: "prev,next today",
                    center: "title",
                    right: "resourceDay"
                },
                titleFormat: "ddd, MMM dd, yyyy",
                defaultView: "resourceDay",
                selectable: true,
                selectHelper: true,
                select: function(start, end, allDay, event, resourceId) {
                    //var title = prompt("Event Title:");
                    var title = $.cookie('patientFName')+" " +$.cookie('patientLName');
                   
                    if (title) {
                    	var refPhys= prompt("Enter Referring Physician name","");
                    	var confirmation = confirm("Adding a reservation for\nPatient: "+title+"\nExamTime: "+start+"\nin Room#: "+resourceId +"\n\nAre You Sure?!");
                    	if (confirmation){
                    	var reservation= new Object();
                    	reservation.reservationExamTime= Date.parse(start)/1000;
                    	reservation.reservationRoomId= resourceId;
                    	reservation.reservationPatientId=parseInt($.cookie('patientId'));
                    	reservation.reservationReferringPhysician=refPhys;
                    	var resUrl = "/RIS/reservation/add?reservationExamTime="+reservation.reservationExamTime+"&reservationRoomId="+reservation.reservationRoomId+"&reservationPatientId="+reservation.reservationPatientId+"&reservationReferringPhysician="+reservation.reservationReferringPhysician;
                    	var res = $.ajax({
            	            url: resUrl,
            	            
            	            async: false,
            	            dataType: 'script'
            	        }).responseText;
                    	res= eval(res);
                    	console.log(res);
                    	console.log(reservation);
                        if(res){
                    	console.log("@@ adding event " + title + ", start " + start + ", end " + end + ", allDay " + allDay + ", resource " + resourceId);
                        calendar.fullCalendar("renderEvent",
                        {
                            title: title,
                            start: start,
                            end: end,
                            allDay: allDay,
                            resourceId: resourceId
                        },
                        true // make the event "stick"
                    );
                        }
                    }
                    	}
                    calendar.fullCalendar("unselect");
                },
                eventResize: function(event, dayDelta, minuteDelta) {
                    console.log("@@ resize event " + event.title + ", start " + event.start + ", end " + event.end + ", resource " + event.resourceId);
                },
                eventDrop: function( event, dayDelta, minuteDelta, allDay) {
                    console.log("@@ drag/drop event " + event.title + ", start " + event.start + ", end " + event.end + ", resource " + event.resourceId);
                },
                editable: true,
                resources: eval(json) ,
                events: eval(eventsJson)
            });
	
        });
	</script>
	<div class ="container">
<%@ include file="topBar.jsp" %>
<%@ include file="menu.jsp" %>
<div id=calendar-space>
	
	<div id='calendar'>
	</div>
	
	</div>
	</div> <!-- end container -->
	<%@ include file="footer.jsp" %>
</body>
</html>