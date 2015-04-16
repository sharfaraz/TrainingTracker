<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create training</title>
</head>
<script type="text/javascript">
var accounts = [ ], towers = [ ], clusters = [ ], applications = [ ];
accounts["att"] = ["A", "B", "C", "D"];
accounts["vodafone"] = ["Italy", "spain"];
accounts["airtel"] = ["Italy", "spain"];
towers["A"] = ["RDC WEB", "RDC MF", "ATT ACUS"];
towers["B"] = ["xyz", "adkj", "kjik"];
towers["C"] = ["rdc", "mf", "aus"];
towers["D"] = ["a", "r", "s"];
clusters["RDC WEB"] = ["IB", "IBS", "JDE"];
clusters["RDC MF"] = ["GBP", "LMM"];
clusters["ATT ACUS"] = ["Billing Consolidator"]

function switchAccount(selAccount) {
	var nextSel = selAccount.form.towers;
	for ( var s = nextSel.options.length-1; s > 0; --s )  {
		nextSel.options[s] = null;
	}
	var chosen = selAccount.options[selAccount.selectedIndex].value;
	var cList = accounts[chosen];
	if ( cList != null )   {
		for ( var i = 0; i < cList.length; ++i )   {
			nextSel.options[i+1] = new Option(cList[i],cList[i]);
		}
	}
}

function switchTower(selTower) {
	var nextSel = selTower.form.clusters;
	for ( var s = nextSel.options.length-1; s > 0; --s )  {
		nextSel.options[s] = null;
	}
	var chosen = selTower.options[selTower.selectedIndex].value;
	var cList = towers[chosen];
	if ( cList != null )   {
		for ( var i = 0; i < cList.length; ++i )   {
			nextSel.options[i+1] = new Option(cList[i],cList[i]);
		}
	}
}

function switchCluster(selCluster) {
	var nextSel = selCluster.form.applications;
	for ( var s = nextSel.options.length-1; s > 0; --s )  {
		nextSel.options[s] = null;
	}
	var chosen = selCluster.options[selCluster.selectedIndex].value;
	var cList = clusters[chosen];
	if ( cList != null )   {
		for ( var i = 0; i < cList.length; ++i )   {
			nextSel.options[i+1] = new Option(cList[i],cList[i]);
		}
	}
}


</script>

<body>
<h2> Create your trainings here!!</h2><br><br>
<form action="SaveTrainingAction" method="post" >  
Training name:<input type="text" name="trainingName" id="training name"/><br>
Delivery Manager:<input type="text" name="delMgr" /><br>
Training start date:<input type="text" name="startDate" /><br>
Training End date:<input type="text" name="endDate" /><br>
Duration:<input type="text" name="numOfDays" /><br>
<h3> Select applicable level</h3>
Account: <select name="accounts" onchange="switchAccount(this);">
<option value="">--Choose account--</option>
<option value="att">ATT</option>
<option value="vodafone">VODAFONE</option>
<option value="airtel">AIRTEL</option>
</select>
Tower: <select name="towers" onchange="switchTower(this);">
<option>--Choose tower--</option>
</select>
Cluster: <select name="clusters"  onchange="switchCluster(this);">
<option value = "">--Choose cluster--</option>
</select>
Application: <select name="applications" onchange="window.alert(this.options[this.selectedIndex].value);">
<option value = "">--Choose application--</option>
</select>

	<%-- <s:textfield key="trainingName" label="Training Name "/><br>
	<s:textfield key="delMgr" label="Delivery Manager "/><br>
	<s:textfield key="startDate" label="Training Start Date"/><br>
	<s:textfield key="endDate" label="Training End date "/><br>
	<s:textfield key="numOfDays" label=" Duration(in days)"/><br>
	<h3>Select the applicable level</h3>
	<s:select label="Account" name="account" headerKey="-1" headerValue="--select account--" list="{'At&t', 'Airtel', 'Vodafone'}"/>
	<s:select label="Tower" name="tower" headerKey="-1" headerValue="--select tower--" list="{'A', 'E', 'F', 'G'}"/>
	<s:select label="Cluster" name="cluster" headerKey="-1" headerValue="--select cluster--" list="{'RDC-WEB', 'RDC-MF', 'ATT-ACUS'}"/> 
	<s:select label="Application" name="app" headerKey="-1" headerValue="--select application--" list="{'IBS', 'IB', 'Billing Consolidator', 'SAART', 'JDE'}"/><br>
	<s:select label="Select the level of training"
	headerKey="-1" headerValue="--select level--"
	list="#{'tower':'Tower', 'account':'Account', 'cluster':'Cluster', 'application':'Application'}"
	name="levelName" /><br> 
	<s:select label="Select entry" 
	headerKey="-1" headerValue="--select app--"
	list="#{'1':'Billing Consolidator', '2':'IBS', '3':'IB', '4':'JDE'}"
	name="levelId" /><br> --%>
	<input type="submit" value="create"/>
</form>


</body>
</html>