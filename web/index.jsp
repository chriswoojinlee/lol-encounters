<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>League of Legends Blacklist</title>
  </head>

  <body>
  <div class="bg-blue-500">
    <h2 class="text-4x1 font-semibold border-b pb-2 mx-6">League of Legends Blacklist</h2>
    <div class="bg-white mx-auto text-center w-1/>2 py-5 shadow-x1 rounded-3x1 my-96 max-w-2x1">
      <form action="/blacklist-servlet" method=""post>
        <div class="grid grid-cols-2 gap-4 my-5 mx-8">
          <label for="userIGN" class="text-x1 flex items-center">Your In-game Username:</label>
          <input id="userIGN" class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg" name="userIGN"/>

          <button type="submit">AccessBlacklist</button>
        </div>
      </form>
    </div>
  </div>
  </body>

  <link rel="stylesheet" href="css/styles.css?v=1.0">
</html>
