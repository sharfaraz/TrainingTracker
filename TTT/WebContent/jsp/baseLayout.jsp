
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/SummaryView.css"	rel="stylesheet" type="text/css" />

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	      <table border="0" cellpadding="0" cellspacing="0" align="center" class="baseTable">
            <tr>
                <td height="25" colspan="2" class="header" style="padding: 0px 0px 0px 0px">
                    <tiles:insertAttribute name="header" />
                </td>                
            </tr>            
            <tr>
            	<td height="30" colspan="2" class="menubody" style="padding: 5px 5px 5px 5px;">
                    <tiles:insertAttribute name="menu" />
                </td>
            </tr>	
            <tr>
                <td width="1200" height="370" style="padding: 5px 5px 5px 5px;">
              <!--   <img height="370" width="1000"  alt="3 in a Box" src="images/3ib.jpg"> -->
                    <tiles:insertAttribute name="body" />
                </td>
            </tr>
           
        </table>
</body>
</html>
