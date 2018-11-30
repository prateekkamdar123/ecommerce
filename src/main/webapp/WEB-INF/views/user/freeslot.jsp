<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: I
  Date: 11/28/2018
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- Mirrored from colorlib.com/polygon/adminator/datatable.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 02 Jul 2018 17:57:21 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head><title>Data Tables</title>
    <spring:url value="/assets/vendor.js" var="vendorJS" />
    <spring:url value="/assets/bundle.js" var="bundleJS" />
    <spring:url value="/assets/style.css" var="styleCSS" />
    <style>#loader {
        transition: all .3s ease-in-out;
        opacity: 1;
        visibility: visible;
        position: fixed;
        height: 100vh;
        width: 100%;
        background: #fff;
        z-index: 90000
    }

    #loader.fadeOut {
        opacity: 0;
        visibility: hidden
    }

    .spinner {
        width: 40px;
        height: 40px;
        position: absolute;
        top: calc(50% - 20px);
        left: calc(50% - 20px);
        background-color: #333;
        border-radius: 100%;
        -webkit-animation: sk-scaleout 1s infinite ease-in-out;
        animation: sk-scaleout 1s infinite ease-in-out
    }

    @-webkit-keyframes sk-scaleout {
        0% {
            -webkit-transform: scale(0)
        }
        100% {
            -webkit-transform: scale(1);
            opacity: 0
        }
    }

    @keyframes sk-scaleout {
        0% {
            -webkit-transform: scale(0);
            transform: scale(0)
        }
        100% {
            -webkit-transform: scale(1);
            transform: scale(1);
            opacity: 0
        }
    }</style>
    <link href="${styleCSS}" rel="stylesheet">
</head>
<body class="app">
<div id="loader">
    <div class="spinner"></div>
</div>
<script type="text/javascript">window.addEventListener('load', () => {
    const loader = document.getElementById('loader');
setTimeout(() => {
    loader.classList.add('fadeOut');
}, 300);
});</script>
<div>
    <div class="sidebar">
        <div class="sidebar-inner">
            <div class="sidebar-logo">
                <div class="peers ai-c fxw-nw">
                    <div class="peer peer-greed"><a class="sidebar-link td-n" href="index.html" class="td-n">
                        <div class="peers ai-c fxw-nw">
                            <div class="peer">
                                <div class="logo"><img src="assets/static/images/logo.png" alt=""></div>
                            </div>
                            <div class="peer peer-greed"><h5 class="lh-1 mB-0 logo-text">Adminator</h5></div>
                        </div>
                    </a></div>
                    <div class="peer">
                        <div class="mobile-toggle sidebar-toggle"><a href="#" class="td-n"><i
                                class="ti-arrow-circle-left"></i></a></div>
                    </div>
                </div>
            </div>
            <jsp:include page="menu.jsp"></jsp:include>
        </div>
    </div>
    <div class="page-container">
        <div class="header navbar">
            <div class="header-container">
                <ul class="nav-left">
                    <li><a id="sidebar-toggle" class="sidebar-toggle" href="javascript:void(0);"><i class="ti-menu"></i></a>
                    </li>
                    <li class="search-box"><a class="search-toggle no-pdd-right" href="javascript:void(0);"><i
                            class="search-icon ti-search pdd-right-10"></i> <i
                            class="search-icon-close ti-close pdd-right-10"></i></a></li>
                    <li class="search-input"><input class="form-control" type="text" placeholder="Search..."></li>
                </ul>
                <ul class="nav-right">
                    <li class="notifications dropdown"><span class="counter bgc-red">3</span> <a href="#"
                                                                                                 class="dropdown-toggle no-after"
                                                                                                 data-toggle="dropdown"><i
                            class="ti-bell"></i></a>
                        <ul class="dropdown-menu">
                            <li class="pX-20 pY-15 bdB"><i class="ti-bell pR-10"></i> <span
                                    class="fsz-sm fw-600 c-grey-900">Notifications</span></li>
                            <li>
                                <ul class="ovY-a pos-r scrollable lis-n p-0 m-0 fsz-sm">
                                    <li><a href="#" class="peers fxw-nw td-n p-20 bdB c-grey-800 cH-blue bgcH-grey-100">
                                        <div class="peer mR-15"><img class="w-3r bdrs-50p"
                                                                     src="../../../randomuser.me/api/portraits/men/1.jpg"
                                                                     alt=""></div>
                                        <div class="peer peer-greed"><span><span class="fw-500">John Doe</span> <span
                                                class="c-grey-600">liked your <span class="text-dark">post</span></span></span>
                                            <p class="m-0">
                                                <small class="fsz-xs">5 mins ago</small>
                                            </p>
                                        </div>
                                    </a></li>
                                    <li><a href="#" class="peers fxw-nw td-n p-20 bdB c-grey-800 cH-blue bgcH-grey-100">
                                        <div class="peer mR-15"><img class="w-3r bdrs-50p"
                                                                     src="../../../randomuser.me/api/portraits/men/2.jpg"
                                                                     alt=""></div>
                                        <div class="peer peer-greed"><span><span class="fw-500">Moo Doe</span> <span
                                                class="c-grey-600">liked your <span class="text-dark">cover image</span></span></span>
                                            <p class="m-0">
                                                <small class="fsz-xs">7 mins ago</small>
                                            </p>
                                        </div>
                                    </a></li>
                                    <li><a href="#" class="peers fxw-nw td-n p-20 bdB c-grey-800 cH-blue bgcH-grey-100">
                                        <div class="peer mR-15"><img class="w-3r bdrs-50p"
                                                                     src="../../../randomuser.me/api/portraits/men/3.jpg"
                                                                     alt=""></div>
                                        <div class="peer peer-greed"><span><span class="fw-500">Lee Doe</span> <span
                                                class="c-grey-600">commented on your <span
                                                class="text-dark">video</span></span></span>
                                            <p class="m-0">
                                                <small class="fsz-xs">10 mins ago</small>
                                            </p>
                                        </div>
                                    </a></li>
                                </ul>
                            </li>
                            <li class="pX-20 pY-15 ta-c bdT"><span><a href="#" class="c-grey-600 cH-blue fsz-sm td-n">View All Notifications <i
                                    class="ti-angle-right fsz-xs mL-10"></i></a></span></li>
                        </ul>
                    </li>
                    <li class="notifications dropdown"><span class="counter bgc-blue">3</span> <a href="#"
                                                                                                  class="dropdown-toggle no-after"
                                                                                                  data-toggle="dropdown"><i
                            class="ti-email"></i></a>
                        <ul class="dropdown-menu">
                            <li class="pX-20 pY-15 bdB"><i class="ti-email pR-10"></i> <span
                                    class="fsz-sm fw-600 c-grey-900">Emails</span></li>
                            <li>
                                <ul class="ovY-a pos-r scrollable lis-n p-0 m-0 fsz-sm">
                                    <li><a href="#" class="peers fxw-nw td-n p-20 bdB c-grey-800 cH-blue bgcH-grey-100">
                                        <div class="peer mR-15"><img class="w-3r bdrs-50p"
                                                                     src="../../../randomuser.me/api/portraits/men/1.jpg"
                                                                     alt=""></div>
                                        <div class="peer peer-greed">
                                            <div>
                                                <div class="peers jc-sb fxw-nw mB-5">
                                                    <div class="peer"><p class="fw-500 mB-0">John Doe</p></div>
                                                    <div class="peer">
                                                        <small class="fsz-xs">5 mins ago</small>
                                                    </div>
                                                </div>
                                                <span class="c-grey-600 fsz-sm">Want to create your own customized data generator for your app...</span>
                                            </div>
                                        </div>
                                    </a></li>
                                    <li><a href="#" class="peers fxw-nw td-n p-20 bdB c-grey-800 cH-blue bgcH-grey-100">
                                        <div class="peer mR-15"><img class="w-3r bdrs-50p"
                                                                     src="../../../randomuser.me/api/portraits/men/2.jpg"
                                                                     alt=""></div>
                                        <div class="peer peer-greed">
                                            <div>
                                                <div class="peers jc-sb fxw-nw mB-5">
                                                    <div class="peer"><p class="fw-500 mB-0">Moo Doe</p></div>
                                                    <div class="peer">
                                                        <small class="fsz-xs">15 mins ago</small>
                                                    </div>
                                                </div>
                                                <span class="c-grey-600 fsz-sm">Want to create your own customized data generator for your app...</span>
                                            </div>
                                        </div>
                                    </a></li>
                                    <li><a href="#" class="peers fxw-nw td-n p-20 bdB c-grey-800 cH-blue bgcH-grey-100">
                                        <div class="peer mR-15"><img class="w-3r bdrs-50p"
                                                                     src="../../../randomuser.me/api/portraits/men/3.jpg"
                                                                     alt=""></div>
                                        <div class="peer peer-greed">
                                            <div>
                                                <div class="peers jc-sb fxw-nw mB-5">
                                                    <div class="peer"><p class="fw-500 mB-0">Lee Doe</p></div>
                                                    <div class="peer">
                                                        <small class="fsz-xs">25 mins ago</small>
                                                    </div>
                                                </div>
                                                <span class="c-grey-600 fsz-sm">Want to create your own customized data generator for your app...</span>
                                            </div>
                                        </div>
                                    </a></li>
                                </ul>
                            </li>
                            <li class="pX-20 pY-15 ta-c bdT"><span><a href="#" class="c-grey-600 cH-blue fsz-sm td-n">View All Email <i
                                    class="fs-xs ti-angle-right mL-10"></i></a></span></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle no-after peers fxw-nw ai-c lh-1"
                                            data-toggle="dropdown">
                        <div class="peer mR-10"><img class="w-2r bdrs-50p"
                                                     src="../../../randomuser.me/api/portraits/men/10.jpg" alt=""></div>
                        <div class="peer"><span class="fsz-sm c-grey-900">John Doe</span></div>
                    </a>
                        <ul class="dropdown-menu fsz-sm">
                            <li><a href="#" class="d-b td-n pY-5 bgcH-grey-100 c-grey-700"><i
                                    class="ti-settings mR-10"></i> <span>Setting</span></a></li>
                            <li><a href="#" class="d-b td-n pY-5 bgcH-grey-100 c-grey-700"><i class="ti-user mR-10"></i>
                                <span>Profile</span></a></li>
                            <li><a href="#" class="d-b td-n pY-5 bgcH-grey-100 c-grey-700"><i
                                    class="ti-email mR-10"></i> <span>Messages</span></a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#" class="d-b td-n pY-5 bgcH-grey-100 c-grey-700"><i
                                    class="ti-power-off mR-10"></i> <span>Logout</span></a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <main class="main-content bgc-grey-100">
            <div id="mainContent">
                <div class="container-fluid"><h4 class="c-grey-900 mT-10 mB-30">Niit Admin Panel</h4>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="bgc-white bd bdrs-3 p-20 mB-20" style="overflow-scrolling: auto"><h4 class="c-grey-900 mB-20">Faculty Details
                            </h4>
                                <table id="dataTable" class="table table-striped table-bordered" cellspacing="0"
                                       width="100%" style="overflow-scrolling: auto">
                                    <thead>
                                    <tr>
                                        <th>Class NO.</th>
                                        <th>Start Time</th>
                                        <th>End Time</th>
                                        <th>Monday</th>
                                        <th>Tuesday</th>
                                        <th>Wednesday</th>
                                        <th>Thursday</th>
                                        <th>Friday</th>
                                        <th>Saturday</th>
                                        <th>Sunday</th>
                                    </tr>
                                    </thead>
                                    <tfoot>
                                    <tr>
                                        <th>Class NO.</th>
                                        <th>Start Time</th>
                                        <th>End Time</th>
                                        <th>Monday</th>
                                        <th>Tuesday</th>
                                        <th>Wednesday</th>
                                        <th>Thursday</th>
                                        <th>Friday</th>
                                        <th>Saturday</th>
                                        <th>Sunday</th>
                                    </tr>
                                    </tfoot>
                                    <tbody>
                                    <c:forEach var="tt" items="${data.ttdata}">
                                        <tr>
                                            <td>${tt.classnumber}</td>
                                            <td>${tt.starttime}</td>
                                            <td>${tt.endtime}</td>
                                            <td>${tt.mondaydetails}</td>
                                            <td>${tt.tuesdaydetails}</td>
                                            <td>${tt.wednesdaydetails}</td>
                                            <td>${tt.thursdaydetails}</td>
                                            <td>${tt.fridaydetails}</td>
                                            <td>${tt.saturdaydetails}</td>
                                            <td>${tt.sundaydetails}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <footer class="bdT ta-c p-30 lh-0 fsz-sm c-grey-600"><span>Copyright Â© 2017 Designed by <a
                href="https://colorlib.com/" target="_blank" title="Colorlib">Colorlib</a>. All rights reserved.</span>
            <!-- Global site tag (gtag.js) - Google Analytics -->
            <script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
            <script>
                window.dataLayer = window.dataLayer || [];

                function gtag() {
                    dataLayer.push(arguments);
                }

                gtag('js', new Date());

                gtag('config', 'UA-23581568-13');
            </script>
        </footer>
    </div>
</div>
<script type="text/javascript" src="${vendorJS}"></script>
<script type="text/javascript" src="${bundleJS}"></script>
</body>
<!-- Mirrored from colorlib.com/polygon/adminator/datatable.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 02 Jul 2018 17:57:21 GMT -->
</html>

