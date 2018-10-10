
<%@ taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<h:head>
    <body class="login">
        <div class="login_form">
            <div class="login_wrapper">
                <section class="login_content">
                    <form action="j_security_check" method="POST">
                        <h1>
                            <span id="line_left"></span>
                            Login
                            <span id="line_right"></span>
                        </h1>
                        <div>
                            <input type="text" class="form-control" placeholder="Username"  name="j_username">
                        </div>

                        <div>
                            <input type="password" class="form-control" placeholder="Password" name="j_password">
                        </div>

                        <div>
                            <button type="submit" class="btn btn-default submit">Acessar</button>
                            <a class="reset_pass" href="#">não lembra suas senha?</a>
                        </div>

                        <div class="clearfix"></div>

                        <div class="separator">

                            <div class="clearfix"></div>
                            <br>

                            <div>
                                <h1><i class="fa fa-paw"></i> Exam Dev</h1>
                                <p>©2016 All Rights Reserved. ZoneWork!</p>
                            </div>
                        </div>
                    </form>
                </section>
            </div>
        </div>
    </body>
</h:head>