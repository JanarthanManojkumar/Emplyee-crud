<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style.css"> 
</head>
<body>

<div class="Container">

<form action="" method="post" id="main">

<h1>Employee Details</h1>

<label>NIC</label><br>
<input type="text" name="NIC">

<div class="from-group">
<label>Name</label><br>
<input type="text" name="Name"><br>
</div>



<label>Department</label>
<select name="Department">
   <option>IT</option>
   <option>Business</option>
   <option>Health</option>
   <option>Government</option>
</select><br>

<div class="from-group">
<label>Designation</label><br>
<input type="Text" name="Designation"><br>
</div>

<div class="from-group">
<label>Date Joined</label><br>
<input type="text" name="DateJoined"><br><br>
</div>

<button type="Submit" onclick="function1()" id="AddBtn">Add Data</button>
<button type="Submit" onclick="function2()" id="DeleteBtn">Delete Data</button>
<button type="Submit" onclick="function3()" id="SearchBtn">View All Data</button>
<button type="Submit" onclick="function4()" id="UpdateBtn">Update Data</button>

</form>
</div>


<script type="text/javascript">


function function1()
{ 
	document.getElementById("main").action="add";
}

function function2()
{ 

	document.getElementById("main").action="delete";
	
	
}

function function3()
{ 
	document.getElementById("main").action="Search";
	
	
}

function function4()
{ 
	document.getElementById("main").action="Update";
	
	
}

</script>

</form>

</body>
</html>
