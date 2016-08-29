using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;

namespace test01.hmwk02
{
    public partial class _Default : System.Web.UI.Page
    {

        private static int cntId = 0;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                prev.Enabled = false;
                image.ImageUrl = "img/image0.jpg";
            }
           
        }

        protected void prev_Click(object sender, EventArgs e)
        { 
            if (!next.Enabled) { next.Enabled = true; }
            cntId--;
            ht(cntId);
            if (0 == cntId)
            {
                prev.Enabled = false;
            }    
        }

        protected void next_Click(object sender, EventArgs e)
        {
  
            if (!prev.Enabled) { prev.Enabled = true; }
            cntId++;
            ht(cntId);

             if (3 == cntId)
            {
                next.Enabled = false;
            }

        }
        private void ht(int id)
        {
           // Console.WriteLine("ht"+id);
            image.ImageUrl = "img/image" + id + ".jpg";
        }
    }
}
