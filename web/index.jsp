<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>League of Legends Blacklist</title>
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css">
  </head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <body class="bg-blue-700">
  <div>
    <div class="bg-white mx-auto text-center w-1/2 py-5 shadow-xl rounded-3xl my-96 max-w-2xl">
      <h2 class="text-4x1 font-semibold border-b pb-2 mx-6">League of Legends Blacklist</h2>
      <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 rounded-lg my-2 mx-auto">${param.error}</h3>
      <div>
        <form action="/user" method="post" id="form1">
          <div class="grid grid-cols-2 gap-4 my-5 mx-8">
            <label for="userIGN" class="text-x1 flex items-center">Enter a new in-game username:</label>
            <input id="userIGN" type="text" name="userIGN" class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg"/>

            <label for="registeredAccount" class="text-x1 flex items-center">Or, enter the username of a previously registered account:</label>
            <input id="registeredAccount" class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg" name="registeredAccount"/>
          </div>
        </form>

        <button type="submit" form="form1" value="submit" class="border-2">Access Account</button>
      </div>
    </div>
  </div>
  </body>
</html>
