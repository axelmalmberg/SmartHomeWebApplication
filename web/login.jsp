<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"><!-- Optional theme -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet"><!-- Latest compiled and minified JavaScript -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
        </script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
        </script>
        <link href="style.css" rel="stylesheet">

        <title>Smart Home - HKR</title>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
    </head>

    <body style="background: url(bg-login.jpg) no-repeat center center fixed;">
        <div class="site-wrapper">
            <div class="site-wrapper-inner">
                <div class="cover-container">
                    <div class="masthead clearfix">
                        <div class="inner">
                            <h3 class="masthead-brand"><a href="index.html">Smart Home - HKR</a></h3>


                            <ul class="nav masthead-nav">
                                <li>Not a member?</li>


                                <li class="next">
                                    <a data-target="#registerModal" data-toggle="modal" href="#">Register <span aria-hidden="true">&rarr;</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>


                    <div class="container">
                        <div class="inner cover">
                            <h1 class="cover-heading">Please sign in</h1>
                            <br>


                            <form action="loginController" class="form-signin">
                                <input autofocus="" class="form-control" name="username" placeholder="Username" type="text"><br>
                                <input class="form-control" name="password" placeholder="Password" type="password"> <input name="function" type="hidden" value="login-info">

                                <div class="checkbox">
                                    <label><input type="checkbox" value="remember-me"> Remember me</label>
                                </div>
                                <button class="btn btn-lg btn-success btn-block" type="submit">Sign in</button>
                            </form>
                            <br>
                            <br>
                        </div>
                    </div>
                    <!-- Modal -->


                    <div class="modal fade" id="registerModal" role="document">
                        <div class="modal-dialog">
                            <!-- Modal content-->


                            <div class="modal-content">
                                <div class="modal-header">
                                    <button class="close" data-dismiss="modal" type="button">&times;</button>

                                    <h4 class="modal-title" style="color: black;">Register</h4>
                                </div>


                                <div class="modal-body" style="color: black;">
                                    <div class="container">
                                        <div class="inner cover">
                                            <br>


                                            <p class="cover-heading">Type in your information</p>
                                            <br>


                                            <form action="loginController" class="form-signin">
                                                <input autofocus="" class="form-control" name="username" placeholder="Username" type="text"><br>
                                                <input class="form-control" name="password" placeholder="Password" type="password"> <input name="function" type="hidden" value="login-info"><br>
                                                <button class="btn btn-lg btn-success btn-block" type="submit">Register</button>
                                            </form>
                                            <br>
                                            <br>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="mastfoot">
                        <div class="inner">
                            <p>Copyright © 2017 TBSYK - <a href="http://hkr.se">Kristianstad University</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>