<jsp:useBean id="registeredAccount" scope="request" class="java.lang.String"/>
<jsp:useBean id="userIGN" scope="request" class="java.lang.String"/>
<jsp:useBean id="error" scope="request" class="java.lang.String"/>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>League of Legends Blacklist</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
  </head>
  <body class="bg-blue-700">
  <div>
    <div class="bg-white mx-auto text-center w-1/2 py-5 shadow-xl rounded-3xl my-96 max-w-2xl">
      <h2 class="text-4x1 font-semibold border-b pb-2 mx-6">League of Legends Blacklist</h2>
      <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 rounded-lg my-2 mx-auto">${error}</h3>
      <div>
        <form action="/landing" method="post">
          <div class="grid grid-cols-2 gap-4 my-5 mx-8">
            <label for="userIGN" class="text-x1 flex items-center">Enter a new in-game username:</label>
            <input id="userIGN" class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg" name="userIGN" value="${userIGN}"/>

            <label for="registeredAccounts" class="text-x1 flex items-center">Alternatively, enter the username of a previously registered account:</label>
            <input id="registeredAccounts" class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg" name="registeredAccounts" value="${registeredAccount}"/>
          </div>

          <form method="get" action="/user">
            <button type="submit">Access Account</button>
          </form>
        </form>
      </div>
    </div>
  </div>
  </body>
</html>
