<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page import="com.dineshonjava.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>

<body>
	<script type="text/javascript">
	
	function onlyNumberKey(evt) {
        var ASCIICode = (evt.which) ? evt.which : evt.keyCode
        if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
            return false;
        return true;
    }
	
		function getDistrictList() {
			var state = $("#state").val();

			$.ajax({
				type : "POST",
				url : "districtList.htm",
				data : "state=" + state,
				success : function(response) {

					$("#DIS").show();
				},
				error : function() {
					alert('Error while request..');
				}
			});

		}

		function validateFields() {

			if (document.forms[0].studentid.value == "") {
				document.getElementById("studentid").focus();
				return false;
			}
			if (document.forms[0].username.value == "") {
				alert('Please Enter User Name :');
				return false;
			}
			if (document.forms[0].schoolcode.value == "") {
				alert('Please Enter School Code :');
				return false;
			}
			if (document.forms[0].standard.value == "") {
				alert('Please Enter Standard :');
				return false;
			}
			if (document.forms[0].section.value == "") {
				alert('Please Enter Section :');
				return false;
			}
			if (document.forms[0].medium.value == "") {
				alert('Please Enter Medium :');
				return false;
			}
			if (document.forms[0].type.value == "") {
				alert('Please Enter Type :');
				return false;
			}
			if (document.forms[0].address.value == "") {
				alert('Please Enter Address :');
				return false;
			}
			if (document.forms[0].state.value == "") {
				alert('Please Enter State :');
				return false;
			}
			if (document.forms[0].district.value == "") {
				alert('Please Enter District`	 :');
				return false;
			}
			if (document.forms[0].mandal.value == "") {
				alert('Please Enter Mandal :');
				return false;
			}
			document.forms[0].submit();
		}
	</script>

	<div align="center" style="background-color: orange;">
		<h1>Person Information</h1>
	</div>
	<div align="center" style="background-color: silver;">
    <br>
		<form:form action="add.htm" method="post" modelAttribute="emp">
			<table border="1" cellpadding="4" cellspacing="5">
				<tr>
					<td>Person ID:</td>
					<td><form:input path="personID" id="personID"
							onkeypress="return onlyNumberKey(event)" /></td>
					<td>Person Name:</td>
					<td><form:input path="personName" id="personName" /></td>
				</tr>
				<tr>
					<td>Father Name:</td>
					<td><form:input path="fatherName" id="fatherName" /></td>
					<td>Mother Name:</td>
					<td><form:input path="motherName" id="motherName" /></td>
				</tr>
				<tr>
					<td>SIR Name:</td>
					<td><form:input path="sirName" id="sirName" /></td>
					<td>DOB:</td>
					<td><form:input path="dob" id="dob" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:radiobutton path="gender" id="gender" value="Male" />:Male<br>
						<form:radiobutton path="gender" id="gender" value="Female"/>:Female<br>
						<form:radiobutton path="gender" id="gender" value="Others" />:Others
					</td>
					<td>Photo:</td>
					<td><form:input type="file" path="file" id="file"/></td>
				</tr>
				<tr>
					<td>Martial Status:</td>
					<td><form:select path="state" id="state">
							<form:option value="0" label="--- Select ---" />
							<form:option value="single" label="Single"/>
							<form:option value="married" label="Married"/>
						</form:select></td>
					<td>Spouse Name:</td>
					<td><form:input path="dob" id="dob" /></td>
				</tr>
				<tr>
					<td>Spouse DOB:</td>
					<td><form:input path="dob" id="dob" /></td>
					<td>Date of Married:</td>
					<td><form:input path="dob" id="dob" /></td>
				</tr>
				<tr>
					<td>Phone Number:</td>
					<td><form:input path="phoneNumber" id="phoneNumber" /></td>
					<td>Nation:</td>
					<td><form:input path="nation" id="nation" /></td>
				</tr>
				<tr>
					<td>Religion:</td>
					<td><form:input path="religion" id="religion" /></td>
					<td>Enter Caste:</td>
					<td><form:input path="caste" id="caste" /></td>
				</tr>
				<tr>
					<td>Aadhar Number:</td>
					<td><form:input path="aadharNumber" id="aadharNumber" /></td>
					<td>Gmail:</td>
					<td><form:input path="gmail" id="gmail" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:textarea path="address" id="address" /></td>
					<td>State:</td>
					<!-- <td>
					<select name="state" id="state">
							<option value="0">--State--</option>
							<option value="AP">AndhraPradesh</option>
							<option value="TGN">Telangana</option>
					</select>
					</td> -->
					<td>
						<%-- <form:select path="state" id="state"
							onchange="getDistrictList()">
							<form:option value="0" label="--- State ---" />
							<form:option value="AP" label="AndhraPradesh" />
							<form:option value="TGN" label="Telangana" />
						</form:select> --%> <form:select path="state" id="state">
							<form:option value="0" label="--- State ---" />
							<form:option value="AP" label="AndhraPradesh" />
							<form:option value="TGN" label="Telangana" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td>District:</td>
					<td><form:select path="district" id="district">
							<form:option value="0" label="--- District ---" />
							<form:option value="WG" label="WestGodavari" />
							<form:option value="KNA" label="Krishna" />
						</form:select></td>
					<td>Mandal:</td>
					<td><form:select path="mandal" id="mandal">
							<form:option value="0" label="--- Mandal ---" />
							<form:option value="WG" label="T.Narasapuram" />
							<form:option value="KNA" label="Janagareddygudem" />
						</form:select></td>
				</tr>
				<tr>
					<td>Village:</td>
					<td><form:input path="village" id="village"/></td>
					<td>Pincode:</td>
					<td><form:input path="pincode" id="pincode"/></td>
				</tr>
			</table>
			<br>
			
			<h5>Fill up the SSC Education Details</h5>
			<table  border="1" cellpadding="4" cellspacing="5">
			<tr>
					<td>Standard:</td>
					<td><form:select path="standard" id="standard">
							<form:option value="0" label="--- Select ---" />
							<form:option value="tenth" label="Tenth" />
							<form:option value="inter" label="Inter" />
							<form:option value="btech" label="B.Tech" />
						</form:select></td>
					<td>Section:</td>
					<td><form:input path="section" id="section" /></td>
				</tr>
				<tr>
					<td>Medium:</td>
					<td><form:input path="medium" id="medium" /></td>
					<td>Type:</td>
					<td><form:input path="type" id="type" /></td>
				</tr>
				<tr>
					<td>Percentage:</td>
					<td><form:input path="percentage" id="percentage"/></td>
					<td>Marks:</td>
					<td><form:input path="marks" id="marks"/></td>
				</tr>
				<tr>
					<td>School Code:</td>
					<td><form:input path="schoolcode" id="schoolcode" /></td>
					<td>School Name:</td>
					<td><form:input path="schoolName" id="schoolName" /></td>
				</tr>
			</table>
			<br>
			
			<h5>Fill up the Inter Education Details</h5>
			<table  border="1" cellpadding="4" cellspacing="5">
			<tr>
					<td>Standard:</td>
					<td><form:select path="standard" id="standard">
							<form:option value="0" label="--- Select ---" />
							<form:option value="tenth" label="Tenth" />
							<form:option value="inter" label="Inter" />
							<form:option value="btech" label="B.Tech" />
						</form:select></td>
					<td>Section:</td>
					<td><form:input path="section" id="section" /></td>
				</tr>
				<tr>
					<td>Medium:</td>
					<td><form:input path="medium" id="medium" /></td>
					<td>Type:</td>
					<td><form:input path="type" id="type" /></td>
				</tr>
				<tr>
					<td>Percentage:</td>
					<td><form:input path="percentage" id="percentage"/></td>
					<td>Marks:</td>
					<td><form:input path="marks" id="marks"/></td>
				</tr>
				<tr>
					<td>College Code:</td>
					<td><form:input path="collegeCode" id="collegeCode" /></td>
					<td>College Name:</td>
					<td><form:input path="collegeName" id="collegeName" /></td>
				</tr>
			</table>
			<br>
			
			<h5>Fill up the B.tech Education Details</h5>
			<table  border="1" cellpadding="4" cellspacing="5">
			<tr>
					<td>Standard:</td>
					<td><form:select path="standard" id="standard">
							<form:option value="0" label="--- Select ---" />
							<form:option value="tenth" label="Tenth" />
							<form:option value="inter" label="Inter" />
							<form:option value="btech" label="B.Tech" />
						</form:select></td>
					<td>Section:</td>
					<td><form:input path="section" id="section" /></td>
				</tr>
				<tr>
					<td>Medium:</td>
					<td><form:input path="medium" id="medium" /></td>
					<td>Type:</td>
					<td><form:input path="type" id="type" /></td>
				</tr>
				<tr>
					<td>Percentage:</td>
					<td><form:input path="percentage" id="percentage"/></td>
					<td>Marks:</td>
					<td><form:input path="marks" id="marks"/></td>
				</tr>
				<tr>
					<td>College Code:</td>
					<td><form:input path="collegeCode" id="collegeCode" /></td>
					<td>College Name:</td>
					<td><form:input path="collegeName" id="collegeName" /></td>
				</tr>
			</table>
			<br>
			<table  border="1" cellpadding="4" cellspacing="5">
			<tr align="center" style="text-align: center;">
					<td colspan='4'><input type="button" value="Submit"
						onclick="validateFields()" /></td>
				</tr>
			</table>
			
			
		</form:form>
	</div>
</body>
</html>