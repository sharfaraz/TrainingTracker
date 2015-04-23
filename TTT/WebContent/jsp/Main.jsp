<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 

<html>
<head>
<sx:head parseContent="true"/>  
<title>Main</title>

	
<style type="text/css">
/* Reset body padding and margins */
body { margin:0; padding:0; }
 
/* Make Header Sticky */
#header_container {height:10%; left:0; position:fixed; width:100%; top:0; }

 
/* CSS for the content of page. I am giving top and bottom padding of 80px to make sure the header and footer do not overlap the content.*/

     
  #ajax_side
   {
   position: fixed;
   width: 80%; 
   height:100%;
   float:right;
   text-align:left;
   left:650px;
   top: 300px;
   z-index: 3;
   display: none;
   } 
   
.dojoTree {
	font: caption;
	font-size: 11px;
	font-weight: normal;
	overflow: auto;
}

.dojoTreeNodeLabel {
	padding: 1px 2px;
	color: WindowText;
	cursor: default;
}

.dojoTreeNodeLabel:hover {
	text-decoration: underline;
}

.dojoTreeNodeLabelSelected {

	background-image:url('images/select.png');
	color: HighlightText;
}

.dojoTree div {
	white-space: nowrap;
}

.dojoTree img {
	vertical-align: middle;
}

.opaqueLayer
            {
                display:none;
                position:absolute;
                top:0px;
                left:0px;
                opacity:0.6;
                filter:alpha(opacity=60);
                background-color: #000000;
                z-Index:1000;
            }
            

            .waitLayer
            {
                position:absolute;
                left:650px;
                top: 300px;
                width:0px;
                height:0px;
                display:none;
                z-Index:1001;
                border:0px;
                text-align:center;
                vertical-align:middle;
                
            }


</style>
</head>
<body>
<script type="text/javascript" src="javascripts/TableManipulation.js"></script>

<script type="text/javascript">

window.onload=function(){
	  var nodes =dojo.widget.manager.getWidgetsByType('struts:StrutsTreeNode');
			for( var i=0; i < nodes.length; i++){
			    nodes[i].expand();
			}
	}
	
	dojo.event.topic.subscribe("treeSelected", function treeNodeSelected(node) {
		var action="";
			
		if(node.node.title=="View/Update Training")
		{
		action="populateEmpFields";
		}
		else if(node.node.title=="Training Details")
		{
		action="managerTrainingDetails";
		}
		else if(node.node.title=="Employee Upload")
		{
		action="empUpload";
		}
		else if(node.node.title=="Create New Training")
		{
			action="createNewTraining";
		}
		else if(node.node.title=="Employee Training Details")
		{
			action="pendingTraining";
		}
		else if((node.node.title=="Generate Reports")&&(node.node.parent.title=="Manager"))
		{
			action="fetchReport";
		}
		else if((node.node.title=="Generate Reports")&&(node.node.parent.title=="SuperUser"))
		{
			action="fetchReport";
		}
		else
			exit;
		
		
		document.getElementById("ajax_side").style.display="block";
		document.getElementById("right_side").style.display="none";
		
       dojo.io.bind({
        url: "<s:url value='"+action+".action'/>",
        load: function(type, data, evt) {
         var divDisplay = dojo.byId("right_side");
         document.getElementById("ajax_side").style.display="none";
         document.getElementById("right_side").style.display="block";
          divDisplay.innerHTML=data;
         	 var scripts = document.createElement('script');
         	scripts.type = 'text/javascript';
         	scripts.async = true;
         	scripts.src = "javascripts/calendar.js";
			var x = document.getElementsByTagName('head')[0];
			x.appendChild(scripts);
			
			var cssFile=document.createElement("link");
			cssFile.setAttribute("rel", "stylesheet")
			  cssFile.setAttribute("type", "text/css")
			  cssFile.setAttribute("href", "Css/calendar.css")
         		document.getElementsByTagName("head")[0].appendChild(cssFile)
        },
        mimeType: "text/html"
    });
});
	 
	
	</script>


 <link rel='stylesheet' href='calendar.css' type='text/css' />
<!-- BEGIN: Sticky Header -->

<!-- END: Sticky Header -->
 
<!-- BEGIN: Page Content -->
<div id="container">
    <div id="content">
    
<sx:tree label="Training Tracker Actions"  id="tree_id" showRootGrid="true" showGrid="false"  treeSelectedTopic="treeSelected" disabled="true">

<sx:treenode label="Employee">
<sx:treenode  label="View/Update Training" />
</sx:treenode>

<sx:treenode label="Employee">
<sx:treenode  label="View/Update Training" />
</sx:treenode>
<sx:treenode label="Manager">
<sx:treenode  label="Employee Training Details" />
<sx:treenode  label="Training Details" />
<sx:treenode  label="Create New Training" />
<sx:treenode  label="Generate Reports" />
</sx:treenode>

<sx:treenode label="Employee">
<sx:treenode  label="View/Update Training" />
</sx:treenode>
<sx:treenode label="SuperUser">
<sx:treenode label="Employee Upload"  />
<sx:treenode  label="Create New Training" />
<sx:treenode  label="Generate Reports" />
</sx:treenode>

</sx:tree>
</div>
<div id="shadow" class="opaqueLayer"> </div>

<div id="ajax_side"><img src="images/ajax-loader_new.gif" alt="ajax loader" /> </div>
<div class="waitLayer" id="wait_side"><img src="images/ajax-wait.gif" alt="ajax loader" /></div>
    <div id="right_side" style="clear:both">
	<!-- Arup -->	
	<s:if test="%{fileUploaded == 'true' }">
		 <s:action name="empUpload" executeResult="true"/>
    </s:if>
	 	 <s:if test="%{fileUploaded!='true'}"> 
		 <s:action name="populateEmpFields" executeResult="true"/>
	</s:if> 
    <!-- Arup -->
    </div>
</div>
</div>
<!-- END: Page Content -->

</body>
</html>

