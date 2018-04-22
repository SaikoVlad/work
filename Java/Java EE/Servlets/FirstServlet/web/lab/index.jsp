<%--
  Created by IntelliJ IDEA.
  User: prostrmk
  Date: 15/02/18
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <%--<link rel="stylesheet" href="../Bootstrap/css/bootstrap.css"/>--%>


</head>
<body>

<%--nav--%>
    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">prostrmk</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.jsp">home<span class="sr-only">(current)</span></a></li>
                    <li><a href="index.jsp">createObject</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Link</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
<%--nav--%>

    <div align="center" class="searcher">
        <form name="objectForm" class="navbar-form navbar-center" action="/lab/validateObject" method="get">
            <div class="form-group">
                <label name="highlabel" id="highlabel"></label>
                <select name="objectSelector" id="objectSelector"  class="custom-select custom-select-lg mb-3">
                    <option id="garland">Garland</option>
                    <option id="stuffedtoy">Stuffed toy</option>
                    <option id="lights">Lights</option>
                </select>
                <button type="submit" onchange="check()" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>


<script>
    function check() {
        var selector = document.objectForm.objectSelector;
        var url = ("/lab/validateObject?" + selector.value);
        window.location.href = url;
    }
</script>





</body>
</html>
