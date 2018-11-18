<jsp:useBean id="credentials" scope="session" type="br.com.zonework.security.domain.entity.Credential"/>

<%@ tag description="Template" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>

<%@ attribute name="title" type="java.lang.String" %>

<h:head title="${title}">
    <jsp:body>
        <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        <div class="navbar nav_title" style="border: 0;">
                            <a href="${pageContext.request.contextPath}/dashboard" class="site_title">
                                <i class="fa fa-paw"></i>
                                <span>Candidate Dev</span>
                            </a>
                        </div>

                        <div class="clearfix"></div>

                        <!-- menu profile quick info -->
                        <div class="profile clearfix">
                            <div class="profile_pic">
                                <img src="${pageContext.request.contextPath}/assets/images/members/images.jpeg"
                                     alt="..." class="img-circle profile_img">
                            </div>
                            <div class="profile_info">
                                <span>Welcome,</span>
                                <h2>John Doe</h2>
                            </div>
                        </div>

                        <div class="clearfix"></div>

                        <br/>

                        <h:sidebar credentials="${credentials}"/>

                    </div>
                </div>

                <h:topbar credentials="${credentials}"/>

                <div class="right_col" role="main">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>${title}</h2>

                                    <div class="clearfix"></div>
                                </div>
                            </div>

                            <div class="x_content">
                                <jsp:doBody/>
                            </div>
                        </div>
                    </div>
                </div>

                <footer>
                    <div class="pull-right">
                        Candidate Dev - Projeto construido na UTFPR
                    </div>

                    <div class="clearfix"></div>
                </footer>
            </div>
        </div>

        <c:if test="${!empty error}">
            <div class=".error" role="errors">${error}</div>
        </c:if>

        <script src="${pageContext.request.contextPath}/assets/vendor/jquery/dist/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/jquery-sparkline/dist/jquery.sparkline.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/nprogress/nprogress.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/pnotify/dist/pnotify.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/errors_messages.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>

        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-buttons/js/buttons.flash.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
        </body>
    </jsp:body>
</h:head>

