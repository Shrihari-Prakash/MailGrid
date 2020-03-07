
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mail Grid | Compose</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">

    </head>
    <body background="bg.jpg" style="background-size: 100%; background-attachment: fixed;">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <form name="compose" id="compose" action="ComposeServlet" method="get" >
            <nav>
                <div class="nav-wrapper">
                    <div class="col s12"><div class="panel light-blue accent-4">
                            <a href="#!" class="breadcrumb">Home</a>
                            <a href="#!" class="breadcrumb">Compose</a>
                        </div>
                    </div>
                </div>
            </nav>
            <div class="row">
                <div class="col s12 m6">
                    <div class="card blue-white lighten-1" > 
                        <div class="card-content black-text">

                            <img src='email-icon.png'width="48" height="48"style="float:left;margin-top: 1px; margin-left: -5px"> <h5 style="margin-left: 56px">Mail Grid</h5><font style="margin-left: 56px">- An Inter Organization Email Framework.</font>
                        </div>  
                    </div> 
                </div> 
            </div>

            <div class="row">
                <div class="col s12 m6">
                    <div class="card blue-white lighten-1"> 
                        <div class="card-content black-text">
                            <a href="InboxView">Go to Inbox</a><a href="LogoutServlet"> | Logout</a>
                            <span class="card-title">Compose Your Message:</span><br>

                            <b>To Email:</b><br>
                            <div class="input-field inline"><input id="toemail" name="toemail" type="text" class="validate">
                                <label for="email" data-error="wrong" data-success="right"></label><br>
                                <br>
                            </div>
                            <br>
                            <b>Content:</b> 
                            <br>  
                            <br>

                            <div class="row">
                                <div class="input-field col s6">
                                    <textarea rows="6" cols="300" id="content" name="content" class="materialize-textarea">
                                    </textarea><br>
                                </div>
                            </div>
                            <button class="btn waves-effect waves- light-blue darken-4" type="submit" name="action">SEND</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div class="row">
            <div class="col s12 m6">
                <div class="card blue-white lighten-1"> 
                    <div class="card-content black-text">
                        <a href="InboxView">Go to Inbox</a><a href="LogoutServlet"> | Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
