<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>List Page</h1>
            <a href="write" class="btn btn-outline-warning">게시글 등록</a>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th>#번호</th>
                    <th>제목</th>
                    <th>작성시간</th>
                </tr>
            </thead>
            <tbody>             
            </tbody>
        </table>
    </div>

    <script>
    $(document).ready(function() {
        $.ajax({
            type: "GET",
            url: "/allview", // 서버에서 데이터를 가져올 URL
            dataType: "json",
            success: function(data) {

                let list = "";
                $.each(data, function(index, item) {            	 
                    list += "<tr><td>" + item.no + "</td>"
                            + "<td><a href='/view?no=" + item.no + "'>" + item.title + "</td>"
                            + "<td>" + item.date + "</td></tr>";
                });
                $("tbody").html(list);
            }
        });
    });
    </script>
</body>
</html>
