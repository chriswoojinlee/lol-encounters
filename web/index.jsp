<jsp:useBean id="error" scope="session" class="java.lang.String"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>
        League of Legends Blacklist
    </title>
    <style>
        html, body {
            width: 100%;
            height: 50%;
        }
    </style>
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css">
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<body class="bg-gray-900 bg-auto">
<div>
    <div class="font-serif bg-white mx-auto text-center py-4 my-80 max-w-2xl">
        <h2 class="text-4xl font-bold border-b pb-2 mx-6">League of Legends Blacklist</h2>
        <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 mx-auto">${error}</h3>
        <div>
            <form action="/user" method="post" id="form1">
                <div class="grid grid-cols-2 gap-4 my-5 mx-1">
                    <label for="userIGN" class="text-2x2 flex items-center">Enter an in-game username:</label>
                    <input id="userIGN" type="text" name="userIGN"
                           class="w-full p-1 border-2 placeholder-red-700 border-red-700 appearance-none"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
