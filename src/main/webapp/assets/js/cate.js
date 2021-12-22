$(function(){
    $(".main_menu a:nth-child(2)").addClass("active");
    $("#add_cate").click(function(){
        $(".popup_wrap").addClass("open");
        $("#add_category").css("display","inline-block");
        $("#modify_category").css("display","none");
        $(".popup .top_area h2").html("카테고리 추가");
        $(".popup .top_area p").html("카테고리 내용을 입력해주세요");
    })
    $("#add_category").click(function(){
        if(confirm("카테고리를 등록하시겠습니까?") == false) return;
        let cate_name = $("#cate_name").val();
        let cate_writer = $("#cate_writer").val();
    
        let data = {
            ci_name : cate_name,
            ci_writer : cate_writer
        }
        $.ajax({
            type:"post",
            url:"/cate/add",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                if(r.status)
                    location.reload();
            }
        })
    })
    $("#cancel_category").click(function(){
        if(confirm("취소하시겠습니까?\n(입력된 정보는 저장되지 않습니다.)") == false) return;
        
        $("#cate_name").val("");
        $("#cate_writer").val("");

        $(".popup_wrap").removeClass("open");
    })

    $(".delete_btn").click(function(){
        if(confirm("카테고리를 삭제하시겠습니까?\n(이 동작은 되돌릴 수 없습니다.)")==false) return;
        let seq = $(this).attr("data-seq");
        $.ajax({
            type:"delete",
            url:"/cate/delete?seq="+seq,
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    });
    let modify_data_seq = 0;

    $(".modify_btn").click(function(){
        modify_data_seq = $(this).attr("data-seq");
        $(".popup_wrap").addClass("open");
        $("#add_category").css("display", "none");
        $("#modify_category").css("display", "inline-block");
        $(".popup .top_area h2").html("카테고리 수정");
        $(".popup .top_area p").html("수정할 내용을 입력해주세요");

        $.ajax({
            type:"get",
            url:"/cate/get?seq="+$(this).attr("data-seq"),
            success:function(r){
                console.log(r);
                $("#cate_name").val(r.data.ci_name);
                $("#cate_writer").val(r.data.ci_writer);
            }
        })
    })
    $("#modify_category").click(function(){
        // alert(modify_data_seq)
        if(confirm("수정하시겠습니까?") == false) return;

        let cate_name = $("#cate_name").val();
        let cate_writer = $("#cate_writer").val();
    
        let data = {
            ci_seq:modify_data_seq,
            ci_name : cate_name,
            ci_writer : cate_writer,
        }
        $.ajax({
            type:"patch",
            url:"/cate/update",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
})