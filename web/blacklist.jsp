<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.userIGN}'s Blacklist</title>
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css">

    <script>
        function goBack() {
            window.history.back()
        }
    </script>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<body class="bg-blue-700">
<div>
    <div class="bg-white mx-auto text-center w-1/2 py-5 shadow-xl rounded-3xl my-96 max-w-2xl">
        ${param.userIGN}'s Blacklist

        <button onclick="goBack()" class="border-2">Go Back</button>
    </div>
</div>
</body>
</html>
