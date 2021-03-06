<!DOCTYPE html>

<html lang="en" class="app">

<head>
    <meta charset="utf-8" />
    <title>HMS</title>
    <meta name="description" content="Dashboard of the HMS Applicaiton." />
    <meta name="author" content="Parth Kinjal Shah" />
    <meta name="Copyright" content="Parth Kinjal Shah 2018" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="CSS/app.v2.css" type="text/css" />
    <link rel="stylesheet" href="CSS/font.css" type="text/css" cache="false" />
    <link rel="stylesheet" href="js/calendar/bootstrap_calendar.css" type="text/css" cache="false" />
    <!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js" cache="false"></script>
    <script src="js/ie/respond.min.js" cache="false"></script>
    <script src="js/ie/excanvas.js" cache="false"></script> <![endif]-->
</head>

<body>
    <section class="vbox">
        <header class="bg-dark dk header navbar navbar-fixed-top-xs">
            <div class="navbar-header aside-md">
                <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen" data-target="#nav">
                    <i class="fa fa-bars"></i>
                </a>
                <a href="index.jsp" class="navbar-brand" data-toggle="fullscreen">
                    HMS
                </a>
                <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".nav-user">
                    <i class="fa fa-cog"></i>
                </a>
            </div>
            <ul class="nav navbar-nav hidden-xs">
                <li class="dropdown">
                    <section class="dropdown-menu aside-xl on animated fadeInLeft no-borders lt">

                        <div class="row m-l-none m-r-none m-b-n-xs text-center">
                            <div class="col-xs-4">
                                <div class="padder-v">
                                    <span class="m-b-xs h4 block text-white">245</span>
                                    <small class="text-muted">Followers</small>
                                </div>
                            </div>
                            <div class="col-xs-4 dk">
                                <div class="padder-v">
                                    <span class="m-b-xs h4 block text-white">55</span>
                                    <small class="text-muted">Likes</small>
                                </div>
                            </div>
                            <div class="col-xs-4">
                                <div class="padder-v">
                                    <span class="m-b-xs h4 block text-white">2,035</span>
                                    <small class="text-muted">Photos</small>
                                </div>
                            </div>
                        </div>
                    </section>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right hidden-xs nav-user">
                <li class="hidden-xs">

                    <section class="dropdown-menu aside-xl">
                        <section class="panel bg-white">
                            <header class="panel-heading b-light bg-light">
                                <strong>You have <span class="count">2</span>
                                notifications</strong>
                            </header>
                            <div class="list-group list-group-alt animated fadeInRight">
                                <a href="#" class="media list-group-item">
                                    <span class="pull-left thumb-sm"> 
                                        <img src="images/avatar.jpg" alt="John said" class="img-circle"> 
                                    </span>
                                    <span class="media-body block m-b-none"> Use awesome animate.css<br> <small class="text-muted">10 minutes ago</small> 
                                    </span>
                                </a>
                                <a href="#" class="media list-group-item">
                                    <span class="media-body block m-b-none"> 1.0 initial released<br> <small class="text-muted">1 hour ago</small> 
                                    </span>
                                </a>
                            </div>
                            <footer class="panel-footer text-sm">
                                <a href="#" class="pull-right">
                                    <i class="fa fa-cog"></i>
                                </a>
                                <a href="#notes" data-toggle="class:show animated fadeInRight">See all the notifications
                                </a>
                            </footer>
                        </section>
                    </section>
                </li>
                <li class="dropdown hidden-xs">

                    <section class="dropdown-menu aside-xl animated fadeInUp">
                        <section class="panel bg-white">
                            <form role="search">
                                <div class="form-group wrapper m-b-none">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Search">
                                        <span class="input-group-btn"> 
                                                <button type="submit" class="btn btn-info btn-icon">
                                                    <i class="fa fa-search"></i>
                                                </button> 
                                            </span>
                                    </div>
                                </div>
                            </form>
                        </section>
                    </section>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
                        Parth Kinjal Shah 
                    </a>
                    <ul class="dropdown-menu animated fadeInRight">
                        <span class="arrow top"></span>
                        <li><a href="#">Settings</a></li>
                        <li><a href="profile.html">Profile</a></li>
                        <li>
                            <a href="#"> <span class="badge bg-danger pull-right">3</span> Notifications </a>
                        </li>
                        <li><a href="docs.html">Help</a></li>
                        <li class="divider"></li>
                        <li><a href="modal.lockme.html" data-toggle="ajaxModal">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </header>
        <section>
            <section class="hbox stretch">
                <!-- .aside -->
                <aside class="bg-dark lter aside-md hidden-print" id="nav">
                    <section class="vbox">

                        <section class="w-f scrollable">
                            <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="5px" data-color="#333333">
                                <!-- nav -->
                                <nav class="nav-primary hidden-xs">
                                    <ul class="nav">
                                        <li class="active">
                                            <a href="index.html" class="active">
                                                <i class="fa fa-dashboard icon"> 
                                                <b class="bg-danger"></b> 
                                            </i>
                                                <span>Dashboard</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#layout">
                                                <i class="fa fa-columns icon"> 
                                                <b class="bg-warning"></b>
                                            </i>
                                                <span class="pull-right"> 
                                                <i class="fa fa-angle-down text"></i> 
                                                <i class="fa fa-angle-up text-active"></i> 
                                            </span>
                                                <span>Patient Records</span>
                                            </a>
                                            <ul class="nav lt">
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>New Records</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Update Records</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>View Patients</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="#uikit">
                                                <i class="fa fa-flask icon"> 
                                                <b class="bg-success"></b> 
                                            </i>
                                                <span class="pull-right"> <i class="fa fa-angle-down text">
                                                
                                                </i> <i class="fa fa-angle-up text-active"></i> 
                                            </span>
                                                <span>Billings</span>
                                            </a>
                                            <ul class="nav lt">
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>New Bill</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Update bill</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>View Bill</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Search Bill</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="#pages">
                                                <i class="fa fa-file-text icon"> 
                                                <b class="bg-primary"></b>
                                            </i>
                                                <span class="pull-right"> 
                                                    <i class="fa fa-angle-down text"></i> 
                                                    <i class="fa fa-angle-up text-active"></i> 
                                            </span>
                                                <span>Appointments</span>
                                            </a>
                                            <ul class="nav lt">
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>New Appointments</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Update Appointments</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Delete Appointment</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>View Appointment</span>
                                                    </a>
                                                </li>
                                            </ul>

                                        </li>
                                        <li>
                                            <a href="#pages">
                                                <i class="fa fa-file-text icon"> 
                                                <b class="bg-primary"></b>
                                            </i>
                                                <span class="pull-right"> 
                                                    <i class="fa fa-angle-down text"></i> 
                                                    <i class="fa fa-angle-up text-active"></i> 
                                            </span>
                                                <span>Room Details</span>
                                            </a>
                                            <ul class="nav lt">
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>New Details</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Update Details</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>View Details</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="#pages">
                                                <i class="fa fa-file-text icon"> 
                                                <b class="bg-primary"></b>
                                            </i>
                                                <span class="pull-right"> 
                                                    <i class="fa fa-angle-down text"></i> 
                                                    <i class="fa fa-angle-up text-active"></i> 
                                            </span>
                                                <span>Employee Details</span>
                                            </a>
                                            <ul class="nav lt">
                                                <li>
                                                    <a href="Employee.jsp"> <i class="fa fa-angle-right"></i> <span>New Employee</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Update Details</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Delete Details</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>View Employees</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="#pages">
                                                <i class="fa fa-file-text icon"> 
                                                <b class="bg-primary"></b>
                                            </i>
                                                <span class="pull-right"> 
                                                    <i class="fa fa-angle-down text"></i> 
                                                    <i class="fa fa-angle-up text-active"></i> 
                                            </span>
                                                <span>Salary Details</span>
                                            </a>
                                            <ul class="nav lt">
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>New Record</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Update Record</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Delete Record</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>View Records</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>

                                        <li>
                                            <a href="#pages">
                                                <i class="fa fa-file-text icon"> 
                                                <b class="bg-primary"></b>
                                            </i>
                                                <span class="pull-right"> 
                                                    <i class="fa fa-angle-down text"></i> 
                                                    <i class="fa fa-angle-up text-active"></i> 
                                            </span>
                                                <span>Taxations</span>
                                            </a>
                                            <ul class="nav lt">
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>New Tax Details</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Update Tax Details</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Delete Tax Details</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>View Tax Details</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>

                                        <li>
                                            <a href="#pages">
                                                <i class="fa fa-file-text icon"> 
                                                <b class="bg-primary"></b>
                                            </i>
                                                <span class="pull-right"> 
                                                    <i class="fa fa-angle-down text"></i> 
                                                    <i class="fa fa-angle-up text-active"></i> 
                                            </span>
                                                <span>Files</span>
                                            </a>
                                            <ul class="nav lt">
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Upload Files</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Search Files</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Delete Files</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>View Files</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>

                                        <li>
                                            <a href="#pages">
                                                <i class="fa fa-file-text icon"> 
                                                <b class="bg-primary"></b>
                                            </i>
                                                <span class="pull-right"> 
                                                    <i class="fa fa-angle-down text"></i> 
                                                    <i class="fa fa-angle-up text-active"></i> 
                                            </span>
                                                <span>Birth Details</span>
                                            </a>
                                            <ul class="nav lt">
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>New Birth</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Update Birth Records</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>View Birth Records</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Birth Certificate</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>

                                        <li>
                                            <a href="#pages">
                                                <i class="fa fa-file-text icon"> 
                                                <b class="bg-primary"></b>
                                            </i>
                                                <span class="pull-right"> 
                                                    <i class="fa fa-angle-down text"></i> 
                                                    <i class="fa fa-angle-up text-active"></i> 
                                            </span>
                                                <span>Death Details</span>
                                            </a>
                                            <ul class="nav lt">
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>New Death</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Update Death Records</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>View Death Records</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#"> <i class="fa fa-angle-right"></i> <span>Death Certificate</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>


                                    </ul>
                                </nav>
                                <!-- / nav -->
                            </div>
                        </section>
                        <footer class="footer lt hidden-xs b-t b-dark">
                            <b>Parth Kinjal Shah<br>Copyright &copy 2018</b>
                        </footer>
                    </section>
                </aside>
                <!-- /.aside -->

    <section id="content">
        <section class="vbox">
            <section class="scrollable padder">

                <div class="m-b-md">
                    <h3 class="m-b-none">Enter Employee Details</h3>
                </div>
                <form class="form-horizontal" data-validate="parsley" id="employee-form">
                    <section class="panel panel-default">
                        <header class="panel-heading"> <strong>Employee Details</strong> </header>
                        <div class="panel-body">
                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group"> <label class="col-sm-3 control-label">Enter First Name</label>
                                <div class="col-sm-9">
                                    <input type="text" data-notblank="true" class="form-control" name="firstName" v-model="firstName" placeholder="Employee Name">
                                </div>
                            </div>
                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group"> <label class="col-sm-3 control-label">Enter Surname Name</label>
                                <div class="col-sm-9">
                                    <input type="text" data-notblank="true" class="form-control" v-model="lastName" name="lastName" placeholder="Employee Name">
                                </div>
                            </div>

                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group"> <label class="col-sm-3 control-label">Email ID</label>
                                <div class="col-sm-9">
                                    <input type="email" class="form-control" placeholder="Enter email address" v-model="emailId" name="emailId">
                                </div>
                            </div>
                            <div class="line line-dashed line-lg pull-in"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Gender</label>
                                <div class="col-sm-9">
                                    <select data-required="true" class="form-control"  v-model="gender" name="gender">
                                        <option value="">Please choose</option>
                                        <option value="bar">Male</option>
                                        <option value="bar">Female</option>
                                        <option value="bar">Others</option>
                                    </select>
                                </div>
                            </div>

                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Designation</label>
                                <div class="col-sm-9">
                                    <select data-required="true" class="form-control" v-model="designation" name="designation">
                                        <option value="">Please choose</option>
                                        <option value="bar">Doctor</option>
                                        <option value="bar">Nurse and wardboy</option>
                                        <option value="bar">Reception</option>
                                        <option value="bar">Admin</option>
                                    </select>
                                </div>
                            </div>

                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">D.O.B</label>
                                <div class="col-sm-9">
                                    <input type="date" class="form-control" placeholder="Enter Date of birht"  name="dateOfBirth">
                                </div>
                            </div>

                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group"> <label class="col-sm-3 control-label">Primary Number</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" placeholder="Enter Mobile Number" v-model="primayNumber" name="primayNumber">
                                </div>
                            </div>
                              <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Password</label>
                                <div class="col-sm-9">
                                    <input type="text" data-min="6" class="form-control" v-model="password" placeholder="Enter passwrod with minimum 6 alphanumeric" name="password">
                                </div>
                            </div>

                        </div>
                        <footer class="panel-footer text-right bg-light lter"> <button type="submit" class="btn btn-success btn-s-xs" @click="addData" >Submit</button> </footer>
                    </section>
                </form>

            </section>
        </section>
        <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a>
    </section>
    <!--/Contents-->


    <aside class="bg-light lter b-l aside-md hide" id="notes">
        <div class="wrapper">Notification</div>
    </aside>

    <script src="../js/app.v2.js"></script>
   <!--Scripts for better working-->
    <script src="js/app.v2.js"></script>
    <!-- Bootstrap -->
    <!-- App -->
    <script src="js/charts/easypiechart/jquery.easy-pie-chart.js" cache="false"></script>
    <script src="js/charts/sparkline/jquery.sparkline.min.js" cache="false"></script>
    <script src="js/charts/flot/jquery.flot.min.js" cache="false"></script>
    <script src="js/charts/flot/jquery.flot.tooltip.min.js" cache="false"></script>
    <script src="js/charts/flot/jquery.flot.resize.js" cache="false"></script>
    <script src="js/charts/flot/jquery.flot.grow.js" cache="false"></script>
    <script src="js/charts/flot/demo.js" cache="false"></script>
    <script src="js/calendar/bootstrap_calendar.js" cache="false"></script>
    <script src="js/calendar/demo.js" cache="false"></script>
    <script src="js/sortable/jquery.sortable.js" cache="false"></script>
    <script>

        var vm = new Vue({
            el: '#employee-form',
            data: {
                
                    firstName : '',
                    lastName: '',
                    emailId: '',
                    gender: '',
                    primayNumber: '',
                    password: '',
                    designation: '',
                    dateOfBirth: '2012-09-09'
            
                },
                methods: {
                    addData: function() {
                        console.log('firstName: ' + this.firstName)
                        console.log('lastName: ' + this.lastName)
                        console.log('gender: ' + this.gender)
                        console.log('emailId: ' + this.emailId)

                        axios.post('http://localhost:8080/employees', {
                          firstName : this.firstName,
                          lastName :  this.lastName,
                          gender:  this.gender,
                          emailId:  this.emailId,
                          primayNumber: this.primayNumber,
                          password: this.password,
                          designation: this.designation,
                          dateOfBirth: this.dateOfBirth
                        },
                       { headers : {
                          'Content-Type': 'application/json'
                        }
                       })
                        .then(r => {
                          console.log(r + "data inserted successfully")
                           window.alert('Data inserted successfully...')
                        })
                        .catch(error => {
                          console.log(error.response)
                        })
                    }
                }
            })
  
    </script>
    </body>
    </html>
