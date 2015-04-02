
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/SummaryView.css" rel="stylesheet" type="text/css"/>
   
            <title><tiles:insertAttribute name="title" ignore="true" /></title>
    </head>
    <body >
        <table border="0" cellpadding="0" cellspacing="0" align="center" class="baseTable">
            <tr>
                <td height="25" class="header" style="padding: 0px 0px 0px 0px" colspan="2">
                    <tiles:insertAttribute name="header" />
                </td>                
            </tr>     
            <tr style="background-color: #6290D2;">
            	<td colspan="2" style="padding: 1px 1px 1px 1px"></td>
            </tr>       
            <tr>
            	<td height="370" class="menubody" style="padding: 0px 0px 0px 0px; background-color: #6290D2;" width="150">
                    <tiles:insertAttribute name="menu" />
                </td>
           <!--   </tr>	
            <tr>-->
                <td width="1050" height="370" style="padding: 5px 5px 5px 5px;">
              <!--   <img height="370" width="1000"  alt="3 in a Box" src="images/3ib.jpg"> -->
                    <tiles:insertAttribute name="body" />
                </td>
            </tr>
           
        </table>
    </body>
</html>
