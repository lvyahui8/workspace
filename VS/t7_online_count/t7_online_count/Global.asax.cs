using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.SessionState;

namespace t7_online_count
{
    public class Global : System.Web.HttpApplication
    {
        public const String ATTR_NAME = "online"; 
        void Application_Start(object sender, EventArgs e)
        {
            // 在应用程序启动时运行的代码
            Application[ATTR_NAME] = 0;
        }

        void Application_End(object sender, EventArgs e)
        {
            //  在应用程序关闭时运行的代码

        }

        void Application_Error(object sender, EventArgs e)
        {
            // 在出现未处理的错误时运行的代码

        }

        void Session_Start(object sender, EventArgs e)
        {
            // 在新会话启动时运行的代码
            //有新的session产生，表示有新的用户访问应用程序，
            //此时应锁定application对象，防止多线程出错，然后将全局的online属性值加1
            Application.Lock();
            int new_count = (int)Application[ATTR_NAME] + 1;
            Application.Set(ATTR_NAME, new_count);
            Application.UnLock();
        }

        void Session_End(object sender, EventArgs e)
        {
            // 在会话结束时运行的代码。 
            // 注意: 只有在 Web.config 文件中的 sessionstate 模式设置为
            // InProc 时，才会引发 Session_End 事件。如果会话模式设置为 StateServer 
            // 或 SQLServer，则不会引发该事件。
            Application.Lock();
            int new_count = (int)Application[ATTR_NAME] - 1;
            Application.Set(ATTR_NAME, new_count);
            Application.UnLock();
        }

    }
}
