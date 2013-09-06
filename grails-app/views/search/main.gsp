<%--
  Created by IntelliJ IDEA.
  User: noam
  Date: 9/5/13
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Artifact searcher</title>
    <r:require module="jquery"/>
</head>

<body class="body">

<g:formRemote name="executeSearch"
              url="[action: 'search']"
              update="resultsTable">
    <div>
        Query<g:textField name="query"/>
    </div>

    <div>
        <g:submitButton name="search" value="Search"/>
    </div>
</g:formRemote>

<div id="resultsTable">
    <g:render template="results" model="[results: results]"/>
</div>
</body>
</html>