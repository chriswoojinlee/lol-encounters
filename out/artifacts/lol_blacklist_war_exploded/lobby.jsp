<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Lobby</title>
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css">

    <script>
        function goBack() {
            window.history.back()
        }
    </script>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<body class="bg-gray-900 bg-auto">
<div class="font-serif bg-white mx-auto py-4 my-80 max-w-2xl">
    <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 rounded-lg my-2 mx-auto √"><%=session.getAttribute("error")%>
    </h3>
    <div style="border: 1px solid;">
        <div style="display:inline-block;vertical-align:top;">
            <img src="<%=session.getAttribute("p1profileIcon")%>" alt="" style="width:100px;height:100px;">
            <p class="mx-4">
                <%=session.getAttribute("p1level")%>
            </p>
        </div>
    </div>
    <%=session.getAttribute("userIGN")%>
    <button onclick="goBack()" class="my-5 mx-3">Go Back</button>
</div>
</body>
</html>
