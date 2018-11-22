<%-- 
    Document   : home
    Created on : 17-Nov-2018, 17:41:54
    Author     : Mandoka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alphacab Taxi </title>
        
    </head>
    <body>
       
        
      <h1>Taxi Booking System</h1>
        <form method="POST" action="Booking">
        <img src="WEB-INF/img/booking.png" alt="HOME"> 
        <div class="form-group">
	<span class="form-label">Name </span>
	<input class="form-control" name="name" type="text" placeholder="Full name"> </div>
        <div class="form-group">
        <div class="form-group">
	<span class="form-label">Address</span>
	<input class="form-control" name ="address" type="text" placeholder="Address">
	</div>
	<span class="form-label">Email</span>
	<input class="form-control" name="email" type="text" placeholder="Email"></div>
        <div class="form-group">
	<span class="form-label">Phone</span>
	<input class="form-control" name ="phone" type="text" placeholder="Phone number">
	</div>
        <div class="form-group">
	<span class="form-label">Destination Location</span>
	<input class="form-control" name ="destination" type="text" placeholder="Destination Location">
	</div>
         <div class="form-group">
	<span class="form-label">Pickup Date</span>
	<input class="form-control" name="date" type="text" required>
	</div>
        
        <div class="form-group">
	<span class="form-label">Day</span>
	<select class="form-control" name= "day" type="text">
	<option>01</option>
	<option>02</option>
	<option>03</option>
	<option>04</option>
	<option>05</option>
	<option>06</option>
	<option>07</option>
	<option>08</option>
	<option>09</option>
	<option>10</option>
	<option>11</option>
	<option>12</option>
        <option>13</option>
        <option>14</option>
        <option>15</option>
        <option>16</option>
        <option>17</option>
        <option>18</option>
        <option>19</option>
        <option>20</option>
        <option>21</option>
        <option>22</option>
        <option>23</option>
	</select>
	<span class="select-arrow"></span>
        </div>
        
        
        <div class="form-group">
	<span class="form-label">Month</span>
	<select class="form-control" name="month" type="text">
	<option>01</option>
	<option>02</option>
	<option>03</option>
	<option>04</option>
	<option>05</option>
	<option>06</option>
	<option>07</option>
	<option>08</option>
	<option>09</option>
	<option>10</option>
	<option>11</option>
	<option>12</option>
	</select>
        <span class="select-arrow"></span>
        </div>
        
        
        
        <div class="form-group">
	<span class="form-label">Hour</span>
	<select class="form-control" name= "hour" type="text">
	<option>00</option>
        <option>01</option>
	<option>02</option>
	<option>03</option>
	<option>04</option>
	<option>05</option>
	<option>06</option>
	<option>07</option>
	<option>08</option>
	<option>09</option>
	<option>10</option>
	<option>11</option>
	<option>12</option>
        <option>13</option>
        <option>14</option>
        <option>15</option>
        <option>16</option>
        <option>17</option>
        <option>18</option>
        <option>19</option>
        <option>20</option>
        <option>21</option>
        <option>22</option>
        <option>23</option>
        
        
        
	</select>
	<span class="select-arrow"></span>
        </div>
        <div class="form-group">
	<span class="form-label">Min</span>
	<select class="form-control" name="min" type="text">
	<option>05</option>
	<option>10</option>
	<option>15</option>
	<option>20</option>
	<option>25</option>
	<option>30</option>
	<option>35</option>
	<option>40</option>
	<option>45</option>
	<option>50</option>
	<option>55</option>
	</select>
	<span class="select-arrow"></span>
	</div>
        <div class="form-group">
	<span class="form-label">AM/PM</span>
	<select class="form-control">
	<option>AM</option>
	<option>PM</option>
	</select>
	<span class="select-arrow"></span>
	</div>

            
        <div class="form-btn">
	<button class="submit-btn">Book Now</button>
	</div>
	
        </form> 
        <br>
        
        <jsp:include page="foot.jsp"/>
        
          <%
            if (request.getAttribute("message")!=null) {
                out.println(request.getAttribute("message"));
              }
        %>
        
    </body>
</html>
