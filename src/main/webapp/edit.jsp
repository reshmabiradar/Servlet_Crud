<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Movie Information Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

h2 {
	text-align: center;
	color: #333;
}

form {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 100%;
	max-width: 400px;
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 8px;
	color: #555;
}

input[type="text"], input[type="number"], textarea, input[type="file"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="file"] {
	padding: 5px;
}

button {
	background-color: #5cb85c;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
	font-size: 16px;
}

button:hover {
	background-color: #4cae4c;
}
</style>
</head>
<body>

	<h2>Movie Information Form</h2>
	<form action="update-movies" method="post" enctype="multipart/form-data">
		<label for="moviename">Movie Name:</label> 
		<input type="text" id="moviename" name="moviename">
		
		 <label for="description">Description:</label>
		<textarea id="description" name="description" rows="4"></textarea>

		<label for="poster">Poster:</label> 
		<input type="file" id="poster" name="poster">
			
	 <label for="language">Language:</label>
		<select name="language">
			<option>Kannada</option>
			<option>English</option>
			<option>hindi</option>
			<option>tamil</option>
		</select>
		
		 <label> Rating:</label>
		  <input type="number" id="rating"	name="rating" min="1" max="10" step="0.1"> 
		  
		  <label>Genre:</label>
	    <input type="checkbox" name="genre" value="ation">Action
	    <input type="checkbox" name="genre" value="Horor">Horor 
	 	<input type="checkbox" name="genre" value="Telibal">Telibal 
	 	<input type="checkbox" name="genre" value="Comedy">Comedy 
	 	<input type="checkbox" name="genre" value="Tragedy">Tragedy


		<button>Add</button>
	</form>

</body>
</html>
