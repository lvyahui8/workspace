using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace test01.hmwk02
{
    struct EmployInfo {
        public string EmployName;
        public string EmployPhone;
    }

    public partial class placeholder : System.Web.UI.Page
    {
        private static EmployInfo[,] Tel = new EmployInfo[3, 6];

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack) {
                this.Title = "部门电话系统";
                LinkButton1.Text = "教务处";
                LinkButton2.Text = "学生处";
                LinkButton3.Text = "科研处";
                for (int i = 0; i < 3; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        Tel[i, j].EmployName = "吕亚辉" + i + j;
                        Tel[i, j].EmployPhone = "" + i + "0000" + j;
                    }
                }
                Label labelWelcome = new Label();
                labelWelcome.Text = "<b>欢迎使用部门电话查询系统</b>";
                PlaceHolder1.Controls.Add(
                    labelWelcome);
            }
        }

        protected void LinkButton_Click(object sender, EventArgs e)
        {
            PlaceHolder1.Controls.Clear();
            Table tab = new Table();
            PlaceHolder1.Controls.Add(tab);
            LinkButton linkUnit = (LinkButton)sender;
            int numOfUnit = 0;
            switch (linkUnit.ID) { 
                case "LinkButton1":
                    tab.Caption = "<b>教务处职工电话</b>";
                    numOfUnit = 0;
                    break;
                case "LinkButton2":
                    tab.Caption = "<b>学生处职工电话</b>";
                    numOfUnit = 1;
                    break;
                case "LinkButton3":
                    tab.Caption = "<b>科研处职工电话</b>";
                    numOfUnit = 2;
                    break;
                default:
                    break;
            }

            tab.GridLines = GridLines.Both;//设置单元格的框线
            tab.CellPadding = 1;
            tab.CellSpacing = 3;//设置单元个的间距
            tab.Width = 200;
            int num = 0;
            for (int i = 0; i < 3;i++ )
            {
                TableRow myRow = new TableRow();
                for (int j = 0; j < 2; j++)
                {
                    TableCell myCell = new TableCell();
                    if(0==j || 3==j) {
                        myCell.Text = Tel[numOfUnit, num].EmployName;
                    }
                    else
                    {
                        myCell.Text = Tel[numOfUnit, num].EmployPhone;
                        num++;
                    }
                    myRow.Cells.Add(myCell);
                }
                tab.Rows.Add(myRow);
            }
        }
    }
}