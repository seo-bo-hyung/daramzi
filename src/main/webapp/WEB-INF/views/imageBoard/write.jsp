<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page errorPage = "error_view.jsp" %>
<%@ page import = "java.sql.Timestamp" %>
<%@ page import = "java.io.File" %>
<%@ page import = "org.apache.commons.fileupload.FileItem" %>
<%@ page import = "com.common.util.ImageUtil" %>
<%@ page import = "com.common.controller.FileUploadRequestWrapper" %>
<%@ page import = "com.imageBoard.controller.ThemeManager" %>
<%@ page import = "com.imageBoard.vo.Theme" %>
<%@ page import = "com.common.exception.ThemeManagerException" %>

 

<%
      FileUploadRequestWrapper requestWrap = 
            new FileUploadRequestWrapper(request, -1, -1, "C:\\test\\temp");
      HttpServletRequest tempRequest = request;
      request = requestWrap;
%>
<jsp:useBean id = "theme" class = "com.imageBoard.vo.Theme">
      <jsp:setProperty name = "theme" property = "*" />
</jsp:useBean>
<%
      FileItem imageFileItem = requestWrap.getFileItem("imageFile");
      String image = "";
 
      if(imageFileItem.getSize() > 0)
      {
            image = Long.toString(System.currentTimeMillis());
  
            // �̹����� ������ ��ο� ����
            File imageFile = new File("C:\\test", image);
  
            // ���� �̸��� �����̸� ó��
            if(imageFile.exists())
            {
                  for(int i = 0; true; i++)
                  {
                        imageFile = new File("C:\\test", image + "_" + i);
    
                        if(!imageFile.exists())
                        {
                              image = image + "_" + i;
                              break;
                        }
                  }
            }
            imageFileItem.write(imageFile);
  
            // ����� �̹��� ����
            File destFile = new File("C:\\test", image + ".small.jpg");
           ImageUtil.resize(imageFile, destFile, 50, ImageUtil.RATIO);
      }
 
      theme.setRegister(new Timestamp(System.currentTimeMillis()));
      theme.setImage(image);
 
      ThemeManager manager = ThemeManager.getInstance();
      manager.insert(theme);
%>
<script>
      alert("���ο� �̹����� ����߽��ϴ�.");
      location.href = "list.jsp";
</script>
 