<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.userIGN}</title>
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
        <h2 class="text-4x1 font-semibold border-b pb-2 mx-6">${param.userIGN}</h2>
        <img src="<%=session.getAttribute("profileIcon")%>" alt="ProfileIcon">
        <div>
            <%=session.getAttribute("level")%>
            <%=session.getAttribute("tier")%> <%=session.getAttribute("division")%> <%=session.getAttribute("lp")%> LP
            <%=session.getAttribute("wins")%> wins/<%=session.getAttribute("losses")%> losses
            <%=session.getAttribute("winRate")%> % Win Ratio
        </div>
        <div>
            <form method="get" action="/blacklist">
                <div class="grid grid-cols-2 gap-4 my-5 mx-8">
                    <button type="submit">Access ${param.userIGN}'s Blacklist</button>
                </div>
            </form>

            <form method="get" action="/blacklist">
                <div class="grid grid-cols-2 gap-4 my-5 mx-8">
                    <label for="lobby" class="text-x1 flex items-center">Copy and paste lobby:</label>
                    <input id="lobby"
                           class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg"
                           name="lobby" value="${param.lobby}"/>
                </div>
            </form>

            <button onclick="goBack()" class="border-2">Go Back</button>
        </div>
    </div>
</div>
</body>
</html>
