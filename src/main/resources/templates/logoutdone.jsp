<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>対局記録</title>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-lg-4 offset-lg-4">
                <h3 class="text-center mb-3">ログアウトしました</h3>
                
                <p class="text-center">
                <a href="<%= request.getContextPath() %>/login">ログイン画面に戻る</a>
                </p>
            </div>
        </div>
    </div>
</body>
</html>