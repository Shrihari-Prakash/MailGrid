
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mail Grid | Login</title>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
         
    </head>
    <body background="bg.jpg" style="background-size: 100%; background-attachment: fixed;">
             <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
        <form action="ShowDB" method="GET">
            <nav>
    <div class="nav-wrapper">
      <div class="col s12">    <div class="panel light-blue accent-4">
        <a href="index.jsp" class="breadcrumb">Home</a>
        <a href="#!" class="breadcrumb">Login</a>
      </div>
      </div></div>
  </nav>
             <div class="row">
            <div class="col s12 m6">
             <div class="card blue-white lighten-1" > 
                    <div class="card-content black-text">
    
                        <img src='email-icon.png'width="48" height="48"style="float:left;margin-top: 1px; margin-left: -5px"> <h5 style="margin-left: 56px">Mail Grid</h5><font style="margin-left: 56px">- An Inter Organization Email Framework.</font>
                    </div>      </div>      </div>      </div>

            <div class="row">
            <div class="col s12 m6">
             <div class="card blue-white lighten-1"> 
                    <div class="card-content black-text">
                        <span class="card-title">Login To Your Account:</span><br>
            <b>Email:</b><br><div class="input-field inline">
            <input name="email" id="email" type="text" class="validate">
            <label for="email" data-error="wrong" data-success="right"></label><br>
            <br></div>
       
            <b><br>Password:</b> <br><div class="input-field inline">
            <input name="password" id="password" type="password" class="validate">
            <label for="password" data-error="wrong" data-success="right"></label><br>
            </div>  <br>
            
       
    
          
            <br> <button class="btn waves-effect waves- light-blue darken-4" type="submit" name="action">LOGIN
            </button><br><br>
             
        <a href="index.jsp">Don't Have An Account? Create One!</a>
</div></div></div></div> </form>
    </body>
</html>
