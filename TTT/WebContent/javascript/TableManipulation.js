function loadTable()
 {
	
	 $(document).ready(function(){

 
	 $("body").find('input[id$=Date]').datepicker(
		        {dateFormat: "mm/dd/yy", buttonText: 'Velg dato', buttonImage: 'graphics/calendar.png',
		        	changeMonth: true, changeYear: true, yearRange: '2000:2050',});
	 });
	   
 }

function viewEmployee(value){

 // var url="populateEmpFields?someVariable=value";
 var url="EmpPendingTrainingViewForMgr?reporteeEmpID="+value;
 var newwindow = window.open(url,"_blank","directories=no, scrollbars=1,status=no,width=600, height=600,top=0,left=0");
 newwindow.document.body.style.backgroundImage="url('images/content.png')";

}

function createTraining()
{
	
	var trainingName=document.getElementById('NewTrainingName').value;
	
	var trainingType=document.getElementById('trainingType').value;
	
	var trainingCategory=document.getElementById('trainingCateg').value;
	
	var trainingMode=document.getElementById('trainingMode').value;
	
	var assignedType=document.getElementById('assignedType').value;
	
	
	if(trainingName=="" || trainingType=="" || trainingCategory == "" || trainingMode == "")
		{
		alert("Error! Training name, training type, trainging category and mode can not be left blank.");
		return;
		}
	
	if (assignedType=="-1"){
		alert("please select Applicable Criteria");
	}
	else {
		var assignedKey=document.getElementById('assignedKey').value;
		if (assignedKey=="-1") {
			alert("Please select Applicable value");
			return;
		}
	}
	
	var startDate=document.getElementById('NewTrainingStDate').value;
	var endDate=document.getElementById('NewTrainingEndDate').value;

	if (startDate==""){
		alert("Select training startDate");
		return;
	}
	
	if(endDate==""){
		alert("select training endDate");
		return;
	}
	
	
	
	//alert(trainingName+" "+trainingType+" "+trainingCategory);
	
	

	var QUERYSTRING="NewTrainingName="+trainingName+
					"&trainingType="+trainingType+"" +
					"&trainingCateg="+trainingCategory+
					"&assignedType="+assignedType+
					"&NewTrainingStDt="+startDate+
					"&NewTrainingEndDt="+endDate+
					"&assignedKey="+assignedKey+
					"&trainingMode="+trainingMode;
	//alert("QUERYSTRING"+QUERYSTRING);
	// document.getElementById("wait_side").style.display="block";
	if (window.XMLHttpRequest)   
	  { 
	  xmlhttp=new XMLHttpRequest();   
	  }   
	else  
	  {  
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");   
	  }   
	xmlhttp.open("GET","/TTT/commitTraining.action?"+QUERYSTRING,true);   
	xmlhttp.send();  
	xmlhttp.onreadystatechange=function()
	  {
		
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  //alert("Training created successfully 34 :"+xmlhttp.responseText);
		  //document.getElementById("wait_side").style.display="none";
		  hideLayer();
		  document.getElementById("messageDiv").innerHTML=xmlhttp.responseText;
		  clearFields();
		  
	    }
	  };
	
	alert("Training has been Created Successfully !");
	}


function myfunction()
{
	var v=document.getElementById('assignedType').value;
	
	if (window.XMLHttpRequest)   
	  { 
	  xmlhttp=new XMLHttpRequest();   
	  
	  }   
	else  
	  {  
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");   
	  
	  }   
	//document.getElementById("wait_side").style.display="block";
	xmlhttp.open("GET","/TTT/populateCriteria.action?assignedType="+v,true);   
	
	xmlhttp.send();  
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  
		//document.getElementById("wait_side").style.display="none";
	    document.getElementById("AssignedValue").innerHTML=xmlhttp.responseText;
	    }
	  };
	
}

function toCancel()
{
	var retVal = confirm("Changes you made will be lost. Do you want to continue?" );
	   if( retVal == true ){
	     
		   window.location.href="welcomeLink";
	   }else{
	      
		  return false;
	   }
}

function addRow_bill(tableID) {   
	var table = document.getElementById(tableID);

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    var cell1 = row.insertCell(0);
    var element1 = document.createElement("input");
    element1.type = "checkbox";
    element1.name = "checkbox[]";
    cell1.appendChild(element1);


    var cell2 = row.insertCell(1);
    var element2 = document.createElement("input");
    element2.type = "text";
    element2.name = "txtbox[]";
    cell2.appendChild(element2);

    var cell3 = row.insertCell(2);
  var element3 = document.createElement("input");
    element3.type = "text";
    element3.name = "txtbox[]";
    cell3.appendChild(element3);
    
    var cell4 = row.insertCell(3);
    var element4 = document.createElement("input");
    element4.type = "text";
   element4.name = "txtbox[]";
    cell4.appendChild(element4);
   
	}      

function addRow_Training(tableID) {   
	var table = document.getElementById(tableID);

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    var cell1 = row.insertCell(0);
    var element1 = document.createElement("input");
    element1.type = "checkbox";
    element1.name = "checkbox[]";
    cell1.appendChild(element1);


    var cell2 = row.insertCell(1);
    var element2 = document.createElement("input");
    element2.type = "text";
    element2.name = "txtbox[]";
    cell2.appendChild(element2);

    var cell3 = row.insertCell(2);
  var element3 = document.createElement("input");
    element3.type = "text";
    element3.name = "txtbox[]";
    cell3.appendChild(element3);
    
    var cell4 = row.insertCell(3);
    var element4 = document.createElement("input");
    element4.type = "text";
   element4.name = "txtbox[]";
    cell4.appendChild(element4);
    
    var cell5 = row.insertCell(4);
    var element5 = document.createElement("input");
    element5.type = "text";
    element5.name = "txtbox[]";
    cell5.appendChild(element5);

    var cell6 = row.insertCell(5);
  var element6 = document.createElement("input");
    element6.type = "text";
    element6.name = "txtbox[]";
    cell6.appendChild(element6);
    
    var cell7 = row.insertCell(6);
    var element7 = document.createElement("input");
    element7.type = "text";
   element7.name = "txtbox[]";
    cell7.appendChild(element7);
   
    var cell8 = row.insertCell(7);
    var element8 = document.createElement("input");
    element8.type = "text";
    element8.name = "txtbox[]";
    cell8.appendChild(element8);

    var cell9 = row.insertCell(8);
  var element9 = document.createElement("input");
    element9.type = "text";
    element9.name = "txtbox[]";
    cell9.appendChild(element9);
    
    var cell10 = row.insertCell(9);
    var element10 = document.createElement("input");
    element10.type = "text";
   element10.name = "txtbox[]";
    cell10.appendChild(element10);
    
    var cell11 = row.insertCell(10);
    var element11 = document.createElement("input");
    element11.type = "text";
   element11.name = "txtbox[]";
    cell11.appendChild(element11);
    
    var cell12 = row.insertCell(11);
    var element12 = document.createElement("input");
    element12.type = "text";
   element12.name = "txtbox[]";
    cell12.appendChild(element12);
	}   
	
function deleteRow(tableID) {      
	try {      
		var table = document.getElementById(tableID); 
		var rowCount = table.rows.length;           
		for(var i=0; i<rowCount; i++)
		{              
			var row = table.rows[i];     
			var chkbox = row.cells[0].childNodes[0];  
			if(null != chkbox && true == chkbox.checked) {           
				if(rowCount <= 1) {                   
					alert("Cannot delete all the rows.");     
					break;                
					}                    
				table.deleteRow(i);         
				rowCount--;           
				i--;             
				}              
			}            
		}
	catch(e) {  
		alert(e); 
           }      
	}     

function clearFields() {
    document.getElementById("NewTrainingName").value="";
    document.getElementById("NewCourseID").value="";
    document.getElementById("trainingType").value="";
    document.getElementById("trainingCateg").value="";
    document.getElementById("assignedType").value="";
    document.getElementById("assignedKey").value="";
    document.getElementById("NewTrainingStDt").value="";
    document.getElementById("NewTrainingEndDt").value="";
    document.getElementById("NewExtendedDt").value="";
}

// Added by Shivam : Displaying wait bar code -- Starts
function getBrowserHeight() {
    var intH = 0;
    var intW = 0;
   

    if(typeof window.innerWidth  == 'number' ) {
       intH = window.innerHeight;
       intW = window.innerWidth;
    }
    else if(document.documentElement && (document.documentElement.clientWidth || document.documentElement.clientHeight)) {
        intH = document.documentElement.clientHeight;
        intW = document.documentElement.clientWidth;
    }
    else if(document.body && (document.body.clientWidth || document.body.clientHeight)) {
        intH = document.body.clientHeight;
        intW = document.body.clientWidth;
    }


    return { width: parseInt(intW), height: parseInt(intH) };
}




function getSdmForReport()
{
	var v=document.getElementById('tower').value;

	if (window.XMLHttpRequest)   
	{ 
		xmlhttp=new XMLHttpRequest();   
	}   
	else  
	{  
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");   
	}   

	xmlhttp.open("GET","/TTT/populateSDM.action?tower="+v,true);   
	xmlhttp.send();  
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{

			document.getElementById("SdmValue").innerHTML=xmlhttp.responseText;

		}
	};
}

function getDmForReport()
{

	var v=document.getElementById('clusterId').value;

	if (window.XMLHttpRequest)   
	{ 
		xmlhttp=new XMLHttpRequest();   
	}   
	else  
	{  
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");   
	}   

	xmlhttp.open("GET","/TTT/populateDm.action?clusterId="+v,true);   
	xmlhttp.send();  
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{

			document.getElementById("DmValue").innerHTML=xmlhttp.responseText;

		}
	};
}


function myEmployeesReport()
{
	
	var trainingName=document.getElementById('trainingName').value;
	
	var trainingStDate=document.getElementById('NewTrainingStDate').value;
	
	var trainingEndDate=document.getElementById('NewTrainingEndDate').value;
	
	
	if(trainingName=="" || trainingStDate=="" || trainingEndDate == "" )
	{
	alert("Error!  StartDate and EndDate are mandatory.");
	return false;
	}
	
	document.getElementById('tower').value="-1";
	document.getElementById('SdmValue').value="-1";
	document.getElementById('DmValue').value="-1";
	
	return true;
}

function validateReports() {
	
	var trainingName = document.getElementById('trainingName').value;
	
	var trainingStDate=document.getElementById('NewTrainingStDate').value;
	
	var trainingEndDate=document.getElementById('NewTrainingEndDate').value;
	
	var tower=document.getElementById('tower').value;
	
	if(trainingName=="" || trainingStDate=="" || trainingEndDate == "" )
		{
		alert("Error! StartDate and EndDate are mandatory.");
		return false;
		}
	if (tower == "" || tower =="-1") {
		alert("Specify the selection criteria or click \"My Employees\" option");
		return false;
	}
}
/*function getAppForReport()
{

	var v=document.getElementById('MGR_ID').value;

	if (window.XMLHttpRequest)   
	{ 
		xmlhttp=new XMLHttpRequest();   
	}   
	else  
	{  
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");   
	}   

	xmlhttp.open("GET","/TTT/populateApp.action?MGR_ID="+v,true);   
	xmlhttp.send();  
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{

			document.getElementById("AppValue").innerHTML=xmlhttp.responseText;

		}
	};
}
*/