<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>${param.userIGN}</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css">

    <script>
        function goBack() {
            window.history.back()
        }
    </script>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<body class="bg-gray-900 bg-auto">
<div>
    <div class="font-serif bg-white mx-auto py-4 my-80 max-w-2xl">
        <h2 class="text-4xl font-bold border-b pb-2 mx-6">${param.userIGN}</h2>
        <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 rounded-lg my-2 mx-auto text-center"><%=session.getAttribute("error")%>
        </h3>
        <div style="border: 1px solid #000000;">
            <div style="display:inline-block;vertical-align:top;">
                <img src="<%=session.getAttribute("profileIcon")%>" alt="" style="width:100px;height:100px;">
                <p class="mx-4">
                    <%=session.getAttribute("level")%>
                </p>
            </div>
            <div style="display:inline-block;">
                <p class="font-extralight">
                    Ranked Solo
                </p>
                <p class="font-extrabold text-red-700">
                    <%=session.getAttribute("tier")%> <%=session.getAttribute("division")%>
                </p>
                <p>
                   <b><%=session.getAttribute("lp")%></b> <%=session.getAttribute("wins")%> <%=session.getAttribute("losses")%>
                </p>
                <p>
                    <%=session.getAttribute("winRate")%>
                </p>
            </div>
        </div>
        <div style="vertical-align:top;display:inline-block;" class="grid grid-flow-col grid-cols-3 gap-4">
            <div></div>
            <form method="get" action="/blacklist">
                <div class="my-5 mx-3">
                    <button type="submit">Access ${param.userIGN}'s blacklist</button>
                </div>
            </form>
            <div></div>
            <form method="get" action="/blacklist">
                <div class="my-5 mx-3">
                    <label for="lobby" class="text-x1 flex items-center">Copy and paste lobby:</label>
                    <input id="lobby"
                           class="w-full p-1 border-2 border-red-700 appearance-none"
                           name="lobby" value="${param.lobby}"/>
                </div>
            </form>
            <div></div>
            <button onclick="goBack()" class="my-5 mx-3">Go Back</button>
        </div>
    </div>
</div>

<div class="SideContent">
    <div class="TierBox Box">
        <div class="SummonerRatingMedium">
            <div class="Medal tip" title="Ranked Solo">
                <img src="//opgg-static.akamaized.net/images/medals/diamond_1.png?image=q_auto:best&amp;v=1"
                     class="Image">
            </div>
            <div class="TierRankInfo">
                <div class="RankType">Ranked Solo</div>
                <div class="TierRank">Diamond 1</div>
                <div class="TierInfo">
			<span class="LeaguePoints">
				100 LP
			</span>
                    /
                    <span class="WinLose">
															<span class="wins">36W</span>
						<span class="losses">23L</span>
						<br>
						<span class="winratio">Win Ratio 61%</span>
												</span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
