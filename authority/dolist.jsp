<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="liger/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css">
    <style type="text/css">
    </style>
     <style type="text/css"><!-- 权限-->
		.l-button{width: 120px; float: left; margin-left: 10px; margin-bottom:2px; margin-top:2px;}
	</style>
    <script src="liger/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>   
	<script src="liger/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="liger/ligerUI/js/plugins/ligerTree.js" type="text/javascript"></script>
    <script src="liger/ligerUI/js/plugins/ligerLayout.js" type="text/javascript"></script>
    
    
<script src="liger/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
<script src="liger/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
<script src="liger/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
<script src="liger/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="liger/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
<script src="liger/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
<script src="js/TreeDeptData.js" type="text/javascript"></script>
    <script src="js/TreeDeptData.js" type="text/javascript"></script>
    
        <script type="text/javascript">
            $(function ()
            {
                $("#layout1").ligerLayout({ leftWidth: 200,heightDiff:-43});
            });
     </script>
     
     
     <style type="text/css"> 
        .l-tree .l-tree-icon-none img{width:16px; height:16px; margin:3px;}
     </style>
     <script type="text/javascript">
        //左边treejs
        $(function ()
        {
            var myaccount = 'liger/ligerUI/skins/icons/myaccount.gif';
            var memeber = 'liger/ligerUI/skins/icons/memeber.gif';
            var archives = 'liger/ligerUI/skins/icons/archives.gif';
            $("#tree1").ligerTree({
                data: [
                { text: '系统管理', icon: myaccount, children: [
                    { text: '资源管理', icon: myaccount },
                    { text: '角色管理', icon: memeber },
                    { text: '机构管理', icon: myaccount},
                    { text: '用户管理', icon: memeber }
                 ]
                },
                { text: '节点2', icon: myaccount, children: [
                    { text: '节点1.1', icon: archives },
                    { text: '节点1.2', icon: archives },
                    { text: '节点1.3', icon: myaccount},
                    { text: '节点1.4', icon: archives }
                 ]
                 },
                { text: '系统报表', icon: myaccount },
                { text: '其他', icon: myaccount }
            ]
            });
        });
    </script>
     
     <script type="text/javascript">
     //机构管理js
    function alert(message)
    {
        $.ligerDialog.alert(message.toString(), '提示信息');
    }
    function tip(message)
    {
        $.ligerDialog.tip({ title: '提示信息', content: message.toString() });
    }
    var manager;
    $(function ()
    {
        manager = $("#maingrid").ligerGrid({
            columns: [
                { display: '部门名', name: 'name', width: 250, align: 'left', editor: { type: 'text'} },
            { display: '部门标示', name: 'id', width: 250, type: 'int', align: 'left' },
 
            { display: '部门描述', name: 'remark', width: 250, align: 'left', editor: { type: 'text'} },
            { display: '用户权限', name: 'authority', width: 150, align: 'center', 
            	render: function (record, rowindex, value, column) {
                          //this     这里指向grid
                         //record   行数据
                      //rowindex 行索引
                       //value    当前的值，对应record[column.name]
                       //column   列信息
                       //
                       // return "<a href='edit.htm?id=" + value + "'>权限修改面板</a>";
                       return "<a href='editdep.jsp'>权限修改面板</a>";
                  }
             }	
            
            
            
            ], width: '100%', pageSizeOptions: [5, 10, 15, 20], height: '100%',
            onSelectRow: function (rowdata, rowindex)
            {
                $("#txtrowindex").val(rowindex);
            },
            data: TreeDeptData, alternatingRow: false, tree: { columnName: 'name' }, checkbox: false,
            autoCheckChildren: false
        }
        );
    });
    function deleteRow()
    {
        var row = manager.getSelectedRow();
        manager.deleteRow(row);
    }
    var i = -1;
    function getNewData(withchildren)
    {
        i++;
        var dept = $("#txtDept").val();
        var data = {
            name: dept + i,
            id: dept + i,
            remark: dept + i
        };
        if (withchildren)
        {
            data.children = [];
            data.children.push(getNewData());
            data.children.push(getNewData());
            data.children.push(getNewData());
        }
        return data;
    }
    //parent:是否增加到当前节点下面
    function addRow(withchildren)
    {
        var data = getNewData(withchildren);
        var selectRow = manager.getSelectedRow();
        var parentRow = selectRow;
 
        if (manager.isLeaf(parentRow))
        {
            tip('叶节点不能增加子节点');
            return;
        }
 
 
        manager.add(data, null, true, parentRow);
    }
    function appendToCurrentNodeUp()
    {
        var selectRow = manager.getSelectedRow();
        if (!selectRow) return;
        var selectRowParnet = manager.getParent(selectRow);
        var data = getNewData();
        manager.add(data, selectRow, true, selectRowParnet);
    }
    function appendToCurrentNodeDown()
    {
        var selectRow = manager.getSelectedRow();
        if (!selectRow) return;
        var selectRowParnet = manager.getParent(selectRow);
        var data = getNewData();
        manager.add(data, selectRow, false, selectRowParnet);
    }
    function getSelected()
    {
        var row = manager.getSelectedRow();
        if (!row) { alert('请选择行'); return; }
        alert(JSON.stringify(row));
    }
    function getData()
    {
        var data = manager.getData();
        alert(JSON.stringify(data));
    }
    function hasChildren()
    {
        var row = manager.getSelected();
        alert(manager.hasChildren(row));
    }
    function upgrade()
    {
        var row = manager.getSelected();
        manager.upgrade(row);
    }
    function demotion()
    {
        var row = manager.getSelected();
        manager.demotion(row);
    }
    function isLeaf()
    {
        var row = manager.getSelected();
        alert(manager.isLeaf(row));
    }
    function toggle()
    {
        var row = manager.getSelected();
        manager.toggle(row);
    }
    function expand()
    {
        var row = manager.getSelected();
        manager.expand(row);
    }
    function up()
    {
        var row = manager.getSelected();
        manager.up(row);
    }
    function down()
    {
        var row = manager.getSelected();
        manager.down(row);
    }
      
</script>
     
     
     
<style type="text/css"> 
 
        body{ padding:5px; margin:0; padding-bottom:15px;}
        #layout1{  width:100%;margin:0; padding:0;  }  
        .l-page-bottom,.l-page-top{ height:80px; background:#f8f8f8; margin-bottom:3px;}
         
        h4{ margin:20px;}
</style>

</head>
<body style="padding:10px">
  <div class="l-page-top"> <!--<img src="img/logo.jpg" width="160px" height="50px" style="padding:15px"></img> --><h3 align="center">权限管理系统</h3></div>
      <div id="layout1">
            <div position="left">
            	<div style="width: 180px; height: 300px; margin: 10px; float: left; border: 1px solid #ccc;
       	 			overflow: auto;">
        			<ul id="tree1">
        			</ul>
    			</div>
            </div>
            <div position="center" title="角色管理">
				            
				            <div>
				    <div style="margin: 2px;">
				        【增加节点选项】 部门：
				        <input type="text" value="新部门" id="txtDept">
				    </div>
				    <a class="l-button" onclick="deleteRow()">
				        删除选择的行</a> 
				<a class="l-button" onclick="addRow()">增加节点</a> 
				<a class="l-button" onclick="addRow(true)" style="width: 150px;">增加节点(附加子节点)</a>
				<a class="l-button" onclick="appendToCurrentNodeUp()" style="width: 150px;">增加节点到同级别(上方)</a>
				<a class="l-button" onclick="appendToCurrentNodeDown()" style="width: 150px;">增加节点到同级别(下方)</a> 
				<a class="l-button" onclick="upgrade()">升级</a> 
				<a class="l-button" onclick="demotion()">降级</a> 
				<a class="l-button" onclick="expand()">伸展</a> 
				<a class="l-button" onclick="toggle()">伸展/收缩节点</a>
				<a class="l-button" onclick="up()">上移</a> 
				<a class="l-button" onclick="down()">下移</a> 
				<a class="l-button" onclick="isLeaf()">是否叶节点节点</a> 
				<a class="l-button" onclick="getSelected()">获取选中的值(选择行)</a> 
				<a class="l-button" onclick="getData()">获取当前的值</a>
				    <div class="l-clear">
				    </div>
				</div>
				<div id="maingrid">
				</div>
            
            
            <h4>$("#layout1").ligerLayout({ leftWidth: 200,heightDiff:-43});</h4> 
                <br />
                如果上面有其他页面元素，layout会自适应调整
                <br />
                下面有其他页面元素，可以通过高度补差(heightDiff)调整
            </div>  
        </div> 
   <div class="l-page-bottom" align="center">@2015 datacvg.com</div>
</body>
</html>
