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

    <style>
        html, body {
            width: 100%;
            height: 50%;
        }
    </style>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<body class="bg-gray-900 bg-auto">
<div class="font-serif bg-white mx-auto py-4 my-50 max-w-2xl">
    <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 rounded-lg my-1 mx-auto"><%=session.getAttribute("error")%></h3>
    <div>
        <div style="display:inline-block;vertical-align:top;">
            <img src="<%=session.getAttribute("p1ProfileIcon")%>" alt="" style="width:125px;height:125px;">
            <p class="mx-8">
                <%=session.getAttribute("p1Level")%>
            </p>
        </div>
        <div style="display:inline-block;">
            <p class="font-semibold">
                <%=session.getAttribute("p1PlayerName")%>
            </p>

            <p>
            <div style="display: inline-block;" class="font-extrabold text-blue-700 text-2xl">
                <%=session.getAttribute("p1Tier")%> <%=session.getAttribute("p1Division")%>
            </div>
            <div style="display: inline-block;">
                <img src="<%=session.getAttribute("p1TierIcon")%>" alt="" style="width:25px;height:25px;">
            </div>
            </p>

            <p>
                <b><%=session.getAttribute("p1LP")%></b>/<%=session.getAttribute("p1Wins")%> <%=session.getAttribute("p1Losses")%>
            </p>

            <p>
                <%=session.getAttribute("p1WinRate")%>
            </p>

            <p>
                Encountered <%=session.getAttribute("p1NumEncounters")%> times
            </p>
        </div>
    </div>
    <hr/>
    <div>
        <div style="display:inline-block;vertical-align:top;">
            <img src="<%=session.getAttribute("p2ProfileIcon")%>" alt="" style="width:125px;height:125px;">
            <p class="mx- 8">
                <%=session.getAttribute("p2Level")%>
            </p>
        </div>
        <div style="display:inline-block;">
            <p class="font-semibold">
                <%=session.getAttribute("p2PlayerName")%>
            </p>

            <p>
            <div style="display: inline-block;" class="font-extrabold text-blue-700 text-2xl">
                <%=session.getAttribute("p2Tier")%> <%=session.getAttribute("p2Division")%>
            </div>
            <div style="display: inline-block;">
                <img src="<%=session.getAttribute("p2TierIcon")%>" alt="" style="width:25px;height:25px;">
            </div>
            </p>

            <p>
                <b><%=session.getAttribute("p2LP")%></b>/<%=session.getAttribute("p2Wins")%> <%=session.getAttribute("p2Losses")%>
            </p>

            <p>
                <%=session.getAttribute("p2WinRate")%>
            </p>

            <p>
                Encountered <%=session.getAttribute("p2NumEncounters")%> times
            </p>
        </div>
    </div>
    <hr/>
    <div>
        <div style="display:inline-block;vertical-align:top;">
            <img src="<%=session.getAttribute("p3ProfileIcon")%>" alt="" style="width:125px;height:125px;">
            <p class="mx-8">
                <%=session.getAttribute("p3Level")%>
            </p>
        </div>
        <div style="display:inline-block;">
            <p class="font-semibold">
                <%=session.getAttribute("p3PlayerName")%>
            </p>

            <p>
            <div style="display: inline-block;" class="font-extrabold text-blue-700 text-2xl">
                <%=session.getAttribute("p3Tier")%> <%=session.getAttribute("p3Division")%>
            </div>
            <div style="display: inline-block;">
                <img src="<%=session.getAttribute("p3TierIcon")%>" alt="" style="width:25px;height:25px;">
            </div>
            </p>

            <p>
                <b><%=session.getAttribute("p3LP")%></b>/<%=session.getAttribute("p3Wins")%> <%=session.getAttribute("p3Losses")%>
            </p>

            <p>
                <%=session.getAttribute("p3WinRate")%>
            </p>

            <p>
                Encountered <%=session.getAttribute("p3NumEncounters")%> times
            </p>
        </div>
    </div>
    <hr/>
    <div>
        <div style="display:inline-block;vertical-align:top;">
            <img src="<%=session.getAttribute("p4ProfileIcon")%>" alt="" style="width:125px;height:125px;">
            <p class="mx-8">
                <%=session.getAttribute("p4Level")%>
            </p>
        </div>
        <div style="display:inline-block;">
            <p class="font-semibold">
                <%=session.getAttribute("p4PlayerName")%>
            </p>

            <p>
            <div style="display: inline-block;" class="font-extrabold text-blue-700 text-2xl">
                <%=session.getAttribute("p4Tier")%> <%=session.getAttribute("p4Division")%>
            </div>
            <div style="display: inline-block;">
                <img src="<%=session.getAttribute("p4TierIcon")%>" alt="" style="width:25px;height:25px;">
            </div>
            </p>

            <p>
                <b><%=session.getAttribute("p4LP")%></b>/<%=session.getAttribute("p4Wins")%> <%=session.getAttribute("p4Losses")%>
            </p>

            <p>
                <%=session.getAttribute("p4WinRate")%>
            </p>

            <p>
                Encountered <%=session.getAttribute("p4NumEncounters")%> times
            </p>
        </div>
    </div>
    <hr/>
    <button onclick="goBack()" class="my-5 mx-3">Go Back</button>
</div>
</body>
</html>