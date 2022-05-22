<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Students</title>
</head>
<body>
<main>
    <div style="display: flex; justify-content: space-between">
        <div style="margin-left: 5vw">
            <h2>All students:</h2><br>
            <h4>${requestScope.students}</h4>
        </div>
        <div style="width: 35%" >
            <h2>Input student </h2><br>
            <form method="post" action="/students">
                <label for="name" >Name:
                    <input id="name" type="text" name="name">
                </label><br>
                <label for="secondName" >Second Name:
                    <input id="secondName" type="text" name="secondName">
                </label><br>
                <label for="surname" >Surname:
                    <input id="surname" type="text" name="surname">
                </label><br>
                <label for="birthDate" >Birth date:
                    <input id="birthDate" type="date" name="birthDate">
                </label><br>
                <label for="group" >Group:
                    <input id="group" type="number" name="group">
                </label><br>
                <button type="submit">Save</button>
            </form>
        </div>
        <div style="margin-right: 5vw">
            <h2>Delete student</h2><br>
            <form method="get" action="/students/delete">
                <label for="id" >Group:
                    <input id="id" type="number" name="id">
                </label><br>
                <button type="submit">Delete</button>

            </form>
        </div>
    </div>

</main>


</body>

</html>