<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<body>
    <table height="100%" width="100%">
        <tr>
            <td width="10%"></td>
            <td width="20%">
                <P ALIGN=RIGHT>Enter Video Name:</P>
            </td>
            <td width="40%">
                <form name="index" action="/search" method="post">
                    <input name="videoName" type="text" />
                    <input type="submit" value="Submit">
                <form>
            </td>
            <td width="10%"></td>
        </tr>
        <tr>
            <td width="10%"></td>
            <td width="80%" colspan="2">
                <c:if test="${not empty errorMessage}">
                    "${errorMessage}"
                </c:if>
                <c:if test="${empty errorMessage && not empty videoPath}">
                    <video width="560" height="340" controls>
                        <source src="${videoPath}" type='video/mp4; codecs="avc1.42E01E, mp4a.40.2"'>
                    </video>
                </c:if>
            </td>
            <td width="10%"></td>
        </tr>
    </table>
</body>