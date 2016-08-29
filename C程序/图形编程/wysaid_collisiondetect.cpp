#include "graphics.h"
#include <vector>
#include <cstdlib>
#include <cmath>

#define SCREEN_WIDTH	800  //���ں���ֱ���
#define SCREEN_HEIGHT	600  //��������ֱ���
#define BALL_AMOUNT		300  //С��������

#ifdef	PI
#undef	PI
#endif
//����к�2�д�С��
#define PI				3.14159f
#define PI2				(2*PI)
#define FLOATCOMP0(x)	(x < 0.01f && x > -0.01f)

using std::vector;

float getAngleByNormal(float x, float y)
{
	float d = sqrtf(x*x+y*y);
	if(FLOATCOMP0(d)) return .0f;
	float angle = asinf(y / d);
	if(x > .0f)
	{
		if(y > .0f)	return angle;
		else return PI2 + angle;
	}
	else
	{
		return PI - angle;
	}
}

class Ball
{
public:
	Ball() : m_x(SCREEN_WIDTH / 2), m_y(SCREEN_HEIGHT / 2)
	{
		s_speed += .01f;
		m_dx = s_speed * cosf(s_direction);
		m_dy = s_speed * sinf(s_direction);
		m_speed = s_speed;
		m_radius = randomf() * 5.0f + 2.0f;
		m_color = random(0xff0000) + 0xffff;
		s_direction += .1f;
	}

	void update()
	{
		m_x += m_dx;
		m_y += m_dy;

		if(m_x < .0f || m_x > SCREEN_WIDTH)
		{
			m_dx = -m_dx;
			m_x += m_dx;
		}
		if(m_y < .0f || m_y > SCREEN_HEIGHT)
		{
			m_dy = -m_dy;
			m_y += m_dy;
		}

#ifdef _DEBUG
		//�����Ƿ���ڵڶ����ᵽ��С��뾶���ٶ�ѡ�񲻺��ʵ�����
		if(m_x < .0f || m_x > SCREEN_WIDTH || m_y < .0f || m_y > SCREEN_HEIGHT)
		{
			SetWindowTextA(getHWnd(), "��⵽ĳЩ�������!!");
		}

#endif
	}

	void render()
	{
		setfillcolor(m_color);
		setcolor(m_color);
		fillellipse((int)m_x, (int)m_y, (int)m_radius, (int)m_radius);
	}

	void turn(float x, float y)
	{
		float aglBall = getAngleByNormal(-m_dx, -m_dy);
		float aglLine = getAngleByNormal(x, y);
		float angle = 2 * aglLine - aglBall;
		m_dx = cosf(angle) * m_speed;
		m_dy = sinf(angle) * m_speed;
		m_x += m_dx;
		m_y += m_dy;
	}

	void getPos(float& x, float& y)
	{
		x = m_x;
		y = m_y;
	}

	float getRadius() { return m_radius; }
	void setSpeed(float speed) { m_speed = speed; }
	float getSpeed() { return m_speed; }
	~Ball() {}

private:
	float m_x, m_y;
	float m_dx, m_dy;
	float m_radius;
	float m_speed;
	COLORREF m_color;
	static float s_direction;
	static float s_speed;
};

float Ball::s_direction;
float Ball::s_speed = 0.5f;

class Line
{
public:
	Line() {}
	Line(int x1, int y1, int x2, int y2)
		: m_x1(x1), m_y1(y1), m_x2(x2), m_y2(y2), m_maxx(x1), m_minx(x2), m_maxy

		(y1), m_miny(y2)
	{
		if(m_maxx < m_minx) std::swap(m_maxx, m_minx);
		if(m_maxy < m_miny) std::swap(m_maxy, m_miny);
		getLineEquation();
	}
	~Line() {}

	void getLineEquation()  //ax + by + c = 0
	{
		float a = m_y1 - m_y2, b = m_x1 - m_x2, c = m_x1 * m_y2 - m_x2 * m_y1;
		if(FLOATCOMP0(b))
		{
			m_a = 1;
			m_b = 0.0f;
			m_c = -m_x1;
		}
		else
		{
			m_a = a / b;
			m_b = -1.0f;
			m_c = c / b;
		}
		m_d2 = m_a * m_a + m_b * m_b;
		m_d = sqrtf(m_d2);
	}

	void render() { line(m_x1, m_y1, m_x2, m_y2); }

	void collisionDetect(Ball& ball)
	{
		float x,y;
		ball.getPos(x,y);
		float prjX = (m_b*m_b*x - m_a*m_b*y - m_a*m_c) / m_d2;
		float prjY = (m_a*m_a*y - m_b*m_c - m_a*m_b*x) / m_d2;

		if(prjX >= m_minx && prjX <= m_maxx && prjY >= m_miny && prjY <= m_maxy)
		{
			float distance = fabs(m_a * x + m_b * y + m_c) / m_d;
			if(distance < ball.getRadius())
			{
				ball.turn(m_a, m_b);
			}
		}
		else
		{
			//���������Ӷ˵���....
		}
	}

private:
	int m_x1, m_y1;
	int m_x2, m_y2;
	int m_maxx, m_maxy, m_minx, m_miny;
	float m_a, m_b, m_c, m_d, m_d2;
};

class Scene
{
public:
	Scene() : m_activeBallNum(0), m_bUpdate(true), m_bBlurring(true) {}
	~Scene(){}
	void init() { m_ball[0].setSpeed(m_ball[BALL_AMOUNT - 1].getSpeed()); }
	void update()
	{
		static bool bShowTips = true, bAddBalls = true;
		if(bAddBalls && m_activeBallNum < BALL_AMOUNT) ++m_activeBallNum;
		if(kbhit())
		{

			int c;
			switch(c = getch())
			{
			case ' ': m_bUpdate = !m_bUpdate; break;
			case '\r': m_bBlurring = !m_bBlurring; bShowTips = false; break;
			case '+': 
				if((m_activeBallNum += 10) > BALL_AMOUNT) 						  
					m_activeBallNum = BALL_AMOUNT; break;
			case '-': 
				if((m_activeBallNum -= 10) <= 0) m_activeBallNum = 1; 
				bAddBalls = false; break;
			case 8: case 302: if(!m_vec.empty()) m_vec.erase(m_vec.end() - 1); break;
			case 27: bShowTips = !bShowTips; break;
			default:;
			}
			while(kbhit()) getch();
		}
		if(m_bBlurring)	imagefilter_blurring(NULL, 0x60, 0xff);
		else cleardevice();
		if(bShowTips)
		{
			//outtextxy(10, 10, "���С����������(���300)��ɿ��٣��밴'+'��'-'�����ڣ�һ�����ӻ����10��С��");
			//outtextxy(10, 30, "ʹ�ÿո�����Զ�סС�򷽱㻭�ߣ�ʹ�ûس�������ȡ������ģ��!");
			outtextxy(10, 10, "�ٽ���ĩ,�ڴ�ףԸ��λͬѧ:");
			outtextxy(10, 50, "�꿼�ع�,���˶��ǹҿ��ϣ��ѣ�!");
			//outtextxy(10, 50, "ʹ��BackSpace �� Delete�����Գ�����һ�εĻ��ߣ�ֱ����������ֱ��.");
			outtextxy(10, 90, "Ҳϣ��ͬѧ���ڽ���3����˶�����ա�");
			//outtextxy(10, 70, "Ҳ������԰���space�������Ի�һ������Σ�^_^ ");
			//outtextxy(10, 100, "����˵������, û����ֱ�����˵�ļ��,����ܼ�,����ȥ��,����̫û��˼");
			//outtextxy(10, 130, "���ԡ���������С������ֱ�߻�������������Ƕ�Խ�󻬶�Խ�죬�����!");
			//outtextxy(100, 300, "��esc��֮����ʾ����ʧ���ٰ��ͻ����~");
			outtextxy(300, 300, "���д�12���������");
			outtextxy(300, 320, "        ----���ǻ�");
		}
	}

	void addLine()
	{
		static int s_x = 0, s_y = 0;
		static bool isLbuttonDown = false;

		if(mousemsg())
		{
			mouse_msg msg;
			do
			msg = getmouse();
			while(msg.msg == mouse_msg_move && mousemsg());
			if(msg.msg == mouse_msg_down && msg.flags == mouse_flag_left)
			{
				s_x = msg.x;
				s_y = msg.y;
				isLbuttonDown = true;
			}
			if(msg.msg == mouse_msg_up && msg.flags == mouse_flag_left)
			{
				m_vec.push_back(Line(s_x, s_y, msg.x, msg.y));
				isLbuttonDown = false;
			}
		}
		if(isLbuttonDown)
		{
			int x, y;
			mousepos(&x, &y);
			setlinestyle(DASHED_LINE);
			setcolor(RED);
			line(s_x, s_y, x, y);
			setlinestyle(SOLID_LINE);
		}
	}

	void show()
	{
		for(int i = 0; i != m_activeBallNum; ++i)
		{
			if(m_bUpdate) m_ball[i].update();
			m_ball[i].render();
			for(std::vector<Line>::iterator iter = m_vec.begin(); iter != m_vec.end(); ++iter)
			{
				iter->collisionDetect(m_ball[i]);
			}
		}
		setcolor(WHITE);
		for(std::vector<Line>::iterator iter = m_vec.begin(); iter != m_vec.end(); ++iter)
		{
			iter->render();
		}
		addLine();
	}

private:
	Ball m_ball[BALL_AMOUNT];
	vector<Line> m_vec;
	int m_activeBallNum;
	bool m_bBlurring, m_bUpdate;
};

int main()
{
	initgraph(SCREEN_WIDTH, SCREEN_HEIGHT);
	setcaption("����ֱ�ߵ���ײ��⡪��wysaid");
	setbkmode(TRANSPARENT);
	setfont(20, 10, "����");
	setrendermode(RENDER_MANUAL);
	randomize();
	Scene scene;
	scene.init();
	for( ; is_run(); delay_fps(60))
	{
		scene.update();
		scene.show();
	}
	return 0;
}
