<table>
    <tr><th>Artifact Name</th><th>Artifact Version</th></tr>
    <g:each in="${results}" var="result">
        <tr>
            <td>${result.name}</td>
            <td>${result.ver}</td>

        </tr>
    </g:each>
</table>