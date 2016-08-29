using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace test01.validator
{
    public partial class requiredfield : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            DropSpec.Items.Add("--请选择专业--");
            DropSpec.Items.Add("网络技术");
            DropSpec.Items.Add("软件工程");
            DropSpec.Items.Add("多媒体应用");
            DropSpec.Items.Add("计算机维修");
            this.Title = "必须验证客户端应用示例";
        }

        protected void ButtonOK_Click(object sender, EventArgs e)
        {
            LabelResult.Text = "你的学号是：" + TextNum.Text + "<br>" + "你的专业是：" + DropSpec.Text;
        }
    }
}