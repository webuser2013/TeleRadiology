<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-1.6.4.js" type="text/javascript"></script>

<script type="text/javascript">

function postRequest(){
	var jsqonStr = $("#jsonReqTxtAraId").val();
	var requestUrl = $("#postUrlId").val();
	var methodType = $("#methodTypeId").val();
 	alert("Json Request: "+jsqonStr+" \n " + " requestUrl: "+requestUrl+" \n " + " MethodType: "+methodType);
 	$.ajax({
        type: methodType,
        url: requestUrl,
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (responseMsg) {
            alert("Response Message from server: "+JSON.stringify({responseMsg}));
        },

        data: jsqonStr
    });
}

function postFileRequest(){
	var requestUrl = $("#updFilePostUrlId").val();
   	var methodType = $("#methodTypeId").val();
    alert("requestUrl: "+requestUrl+" \n " + " MethodType: "+methodType);
    var form = $("#fileUploadForm")[0];
    var data = new FormData(form);
    $.ajax({
        type : "POST",
        encType : "multipart/form-data",
        url : requestUrl,
        cache : false,
        processData : false,
        contentType : false,
        data : data,
        success : function(responseMsg) {
        	alert("Response Message from server: "+JSON.stringify({responseMsg}));
        }
    });
}

</script>
</head>
<body>
<form name="stimulatorForm">
<table>
	<tr>
		<td> URL </td>
		<td> <input type="text"  id = "postUrlId" size="75"></input> </td> 
	</tr>
	
	<tr>
		<td> Json Request </td>
		<td> <textarea rows="25" cols="40" id = "jsonReqTxtAraId"></textarea> </td> 
	</tr>
	
	<tr>
		<td> Method type </td>
		<td> 
			<select id= "methodTypeId">
				<option value="POST"> POST</option>
				<option value="GET"> GET</option>
			</select> 
		</td> 
	</tr>
	
	<tr>
		<td> </td>
		<td> <input type="button" value="Submit" onclick="postRequest()"> </td> 
	</tr>

</table>
</form>

<form enctype="multipart/form-data" id="fileUploadForm">

<table>
	<tr>
		<td> URL </td>
		<td> <input type="text"  id="updFilePostUrlId" size="75"></input> </td> 
	</tr>
	
	<tr>
		<td> Upload File </td>
		<td> <input type="file" name="file"/></td> 
	</tr>

	<tr>
		<td> </td>
		<td><input type="button" value="Submit" id="fileUploadId" onclick="postFileRequest()" /></td> 
	</tr>

</table>    
    
    
</form>

</body>
</html>