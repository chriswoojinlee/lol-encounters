<jsp:useBean id="error" scope="session" class="java.lang.String"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>
        League of Legends Encounters
    </title>
    <style>
        html, body {
            width: 100%;
            height: 100%;
        }
    </style>
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css">
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<body class="bg-gray-900 bg-auto">
<div>
    <div class="font-serif bg-white mx-auto text-center py-2 my-80 max-w-xl">
        <h2 class="text-4xl font-bold border-b pb-2 mx-6">League of Legends Encounters</h2>
        <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 mx-auto">${error}</h3>
        <div class="mx-12">
            <form action="/user" method="post">
                <div class="grid grid-cols-2 my-5 mx-12">
                    <label for="userIGN" class="text-2x2 flex items-center">Enter an in-game username:</label>
                    <input id="userIGN" type="text" name="userIGN"
                           class="w-3/5 border-2 border-blue-700"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
