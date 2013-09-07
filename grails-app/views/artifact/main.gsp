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
    <title>Artifact manager</title>
</head>

<body class="body">

<g:form action="save">
    <div>
        Artifact Name <g:textField name="artifactName"/>
    </div>

    <div>
        Artifact Version <g:textField name="artifactVersion"/>
    </div>

    <div>
        Artifact Description <g:textField name="artifactDesc"/>
    </div>

    <div>
        <g:submitButton name="saveArtifact" value="Save"/>
    </div>
</g:form>

<table>
    %{--<div class="table-row-div table-header-div">--}%
        <tr><th>Artifact Name</th><th>Artifact Version</th></tr>
    %{--</div>--}%
    <g:each in="${existingArtifacts}" var="existingArtifact">
        %{--<div class="table-row-div">--}%
            <tr>
                <td>${existingArtifact.name}</td>
                <td>${existingArtifact.ver}</td>

            </tr>
        %{--</div>--}%
    </g:each>
</table>
</body>
</html>