<table>
    <tr><th>Artifact Name</th><th>Artifact Version</th><th>Artifact Description <br><small>(not searchable, remember?)</small></th></tr>
    <g:each in="${results}" var="result">
        <tr>
            <td>${result.name}</td>
            <td>${result.ver}</td>
            <td>${result.desc}</td>

        </tr>
    </g:each>
</table>