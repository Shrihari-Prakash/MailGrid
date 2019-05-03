
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mail Grid</title>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
         
    </head>

             <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      <body background="bg.jpg" style="background-size: 100%; background-attachment: fixed;">
        <form action="DBReg" method="get">
            <nav>
    <div class="nav-wrapper">
      <div class="col s12">
    <div class="panel light-blue accent-4">
            
        <a href="#!" class="breadcrumb">Home</a>
      </div>
    </div></div>
  </nav> <div class="row">
            <div class="col s12 m6">
             <div class="card blue-white lighten-1" > 
                    <div class="card-content black-text">
    
                        <img src='email-icon.png'width="48" height="48"style="float:left;margin-top: 1px; margin-left: -5px"> <h5 style="margin-left: 56px">Mail Grid</h5><font style="margin-left: 56px">- An Inter Organization Email Framework.</font>
                    </div>      </div>      </div>      </div>

            <div class="row" >
            <div class="col s12 m6">
             <div class="card blue-white lighten-1"> 
                    <div class="card-content black-text">
    
    
     <span class="card-title">Create An Account!</span><br>
                    <b>Your Name:</b> <span style="padding-left:100px"><div class="input-field inline">
            <input name= "fname"id="fname" type="text" class="uname"required="true">
            <label for="uname" data-error="wrong" data-success="right"></label><br>
                        </div></span>
          
            <br>
            
                <b>Choose An Email Address:</b>
            <div class="input-field inline"><input id="email" name="email" type="text" class="validate" required="true">
            <label for="email" data-error="wrong" data-success="right"></label><br>
            </div><br>
            <b>Create Password:</b> <span style="padding-left:60px"><div class="input-field inline">
            <input name="password" id="password" type="password" class="validate" required="true">
            <label for="password" data-error="wrong" data-success="right"></label><br>
                </div>   <br></span>

            <br> <button class="btn waves-effect waves- light-blue darken-4" type="submit" name="action" onclick="validatePassword()">Create Account!
            </button><br>
              
              
</div></div></div></div>
            
            
                </form> 
             <div class="row">
            <div class="col s12 m6">
             <div class="card blue-white lighten-1"> 
                    <div class="card-content black-text">
       <a href="Login.jsp">Already Have An Account? Login.</a></div></div></div></div>
           </body>         
</html>
