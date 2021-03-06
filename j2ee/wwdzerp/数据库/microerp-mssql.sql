if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Customer]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Customer]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CustomerPrice]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CustomerPrice]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[DealInfo]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[DealInfo]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Delivery]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Delivery]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[DeliveryDetail]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[DeliveryDetail]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[OrderDetail]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[OrderDetail]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[OrderInfo]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[OrderInfo]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Payment]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Payment]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Product]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Product]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemBasicData]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemBasicData]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemBasicDataDetail]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemBasicDataDetail]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemDept]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemDept]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemGroup]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemGroup]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemGroup_SystemRole]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemGroup_SystemRole]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemGroup_SystemUser]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemGroup_SystemUser]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemLogInfo]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemLogInfo]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemPopedom]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemPopedom]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemRegion]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemRegion]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemRole]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemRole]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SystemUser]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SystemUser]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[WaterTicket]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[WaterTicket]
GO

CREATE TABLE [dbo].[Customer] (
	[id] [bigint] NOT NULL ,
	[sn] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[title] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[types] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[leader] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[linkMan] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[tel] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[address] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[zip] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[fax] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[email] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[homePage] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[source] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[rank] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[intro] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[remark] [varchar] (1000) COLLATE Chinese_PRC_CI_AS NULL ,
	[inputUser] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[inputTime] [datetime] NULL ,
	[status] [int] NULL ,
	[province] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[city] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[town] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[parent_id] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[balance] [money] NULL ,
	[ticketNum] [int] NULL ,
	[debt] [money] NULL ,
	[balanceBarrel] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CustomerPrice] (
	[id] [bigint] NOT NULL ,
	[customer_id] [bigint] NULL ,
	[product_id] [bigint] NULL ,
	[price] [money] NULL ,
	[unit] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[vdate] [datetime] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DealInfo] (
	[id] [bigint] NOT NULL ,
	[customer_id] [bigint] NULL ,
	[systemuser_id] [bigint] NULL ,
	[order_id] [bigint] NULL ,
	[sum] [money] NULL ,
	[vdate] [datetime] NULL ,
	[dealType] [int] NULL ,
	[payType] [int] NULL ,
	[payment] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[inputTime] [datetime] NULL ,
	[inputUser] [varchar] (8) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Delivery] (
	[id] [bigint] NOT NULL ,
	[sn] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[carno] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[deliver] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[appointer] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[sender] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[auditing] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[intro] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL ,
	[vdate] [datetime] NULL ,
	[status] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DeliveryDetail] (
	[id] [bigint] NOT NULL ,
	[order_id] [bigint] NULL ,
	[parent_id] [bigint] NULL ,
	[backBottle] [int] NULL ,
	[backWater] [int] NULL ,
	[backAmount] [money] NULL ,
	[intro] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL ,
	[status] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[OrderDetail] (
	[id] [bigint] NOT NULL ,
	[order_id] [bigint] NULL ,
	[product_id] [bigint] NULL ,
	[types] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[num] [float] NULL ,
	[price] [money] NULL ,
	[amount] [money] NULL ,
	[unit] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[status] [int] NULL ,
	[sequence] [int] NULL ,
	[width] [float] NULL ,
	[height] [float] NULL ,
	[unitType] [int] NULL ,
	[cou] [int] NULL ,
	[vdate] [datetime] NULL ,
	[intro] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[beginSn] [int] NULL ,
	[endSn] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[OrderInfo] (
	[id] [bigint] NOT NULL ,
	[sn] [varchar] (16) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[customer_id] [bigint] NULL ,
	[vdate] [datetime] NULL ,
	[requireDate] [datetime] NULL ,
	[payType] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[linkMan] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[tel] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[address] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[requirement] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[remark] [varchar] (1000) COLLATE Chinese_PRC_CI_AS NULL ,
	[amount] [money] NULL ,
	[handPerson] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[inputUser] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[inputTime] [datetime] NULL ,
	[opUser] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[opIntro] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[opTime] [datetime] NULL ,
	[status] [int] NULL ,
	[paymentStatus] [int] NULL ,
	[invoiceSum] [money] NULL ,
	[realSum] [money] NULL ,
	[managerFee] [money] NULL ,
	[workTip] [money] NULL ,
	[donateTickt] [int] NULL ,
	[donateMachine] [int] NULL ,
	[types] [int] NULL ,
	[payment_id] [bigint] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Payment] (
	[id] [bigint] NOT NULL ,
	[vdate] [datetime] NULL ,
	[sum] [money] NULL ,
	[customer_id] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[payUser] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[opUser] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[waterTicket_id] [bigint] NULL ,
	[price] [money] NULL ,
	[num] [int] NULL ,
	[diffSum] [money] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Product] (
	[id] [bigint] NOT NULL ,
	[sn] [varchar] (16) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[title] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[types] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[dir] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[unit] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[buyPrice] [money] NULL ,
	[salePrice] [money] NULL ,
	[pic] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[intro] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[remark] [varchar] (1000) COLLATE Chinese_PRC_CI_AS NULL ,
	[systemUser_id] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[inputTime] [datetime] NULL ,
	[status] [int] NULL ,
	[customer_id] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemBasicData] (
	[id] [bigint] NOT NULL ,
	[sn] [varchar] (16) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[title] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[intro] [varchar] (1000) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemBasicDataDetail] (
	[id] [bigint] NOT NULL ,
	[parent_id] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[title] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[tvalue] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[sequence] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemDept] (
	[id] [bigint] NOT NULL ,
	[sn] [varchar] (16) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[title] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[address] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[tel] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[email] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[linkMan] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[manager] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[types] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[intro] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[remark] [varchar] (1000) COLLATE Chinese_PRC_CI_AS NULL ,
	[inputUser] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[inputTime] [datetime] NULL ,
	[lastLoginTime] [datetime] NULL ,
	[loginTimes] [int] NULL ,
	[status] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemGroup] (
	[id] [bigint] NOT NULL ,
	[title] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[intro] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemGroup_SystemRole] (
	[systemgroup_id] [bigint] NULL ,
	[systemrole_id] [bigint] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemGroup_SystemUser] (
	[systemrole_id] [bigint] NULL ,
	[systemgroup_id] [bigint] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemLogInfo] (
	[id] [bigint] NOT NULL ,
	[opType] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[intro] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[vdate] [datetime] NULL ,
	[userName] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[ip] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemPopedom] (
	[id] [bigint] NOT NULL ,
	[title] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[intro] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL ,
	[parent_id] [bigint] NULL ,
	[status] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemRegion] (
	[id] [bigint] NOT NULL ,
	[title] [varchar] (64) COLLATE Chinese_PRC_CI_AS NULL ,
	[sequence] [int] NULL ,
	[parent_sn] [varchar] (64) COLLATE Chinese_PRC_CI_AS NULL ,
	[lev] [int] NULL ,
	[inputTime] [datetime] NULL ,
	[inputUser] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[sn] [varchar] (64) COLLATE Chinese_PRC_CI_AS NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemRole] (
	[id] [bigint] NOT NULL ,
	[sn] [varchar] (16) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[title] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[intro] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[roleValue] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[status] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SystemUser] (
	[id] [bigint] NOT NULL ,
	[belongDept] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[userName] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[password] [varchar] (32) COLLATE Chinese_PRC_CI_AS NULL ,
	[email] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[trueName] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[tel] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[role] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[lastLoginTime] [datetime] NULL ,
	[lastLoginIP] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[loginTimes] [int] NULL ,
	[inputUser] [varchar] (16) COLLATE Chinese_PRC_CI_AS NULL ,
	[inputTime] [datetime] NULL ,
	[status] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[WaterTicket] (
	[id] [bigint] NOT NULL ,
	[sn] [bigint] NULL ,
	[product_id] [bigint] NULL ,
	[customer_id] [bigint] NULL ,
	[status] [int] NULL ,
	[vdate] [datetime] NULL ,
	[backDate] [datetime] NULL ,
	[consumer_id] [bigint] NULL 
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Customer] WITH NOCHECK ADD 
	CONSTRAINT [PK_Customer] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[CustomerPrice] WITH NOCHECK ADD 
	CONSTRAINT [PK_CustomerPrice] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[DealInfo] WITH NOCHECK ADD 
	CONSTRAINT [PK_DealInfo] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Delivery] WITH NOCHECK ADD 
	CONSTRAINT [PK_Delivery] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[DeliveryDetail] WITH NOCHECK ADD 
	CONSTRAINT [PK_DeliveryDetail] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[OrderDetail] WITH NOCHECK ADD 
	CONSTRAINT [PK_OrderList] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[OrderInfo] WITH NOCHECK ADD 
	CONSTRAINT [PK_OrderInfo] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Payment] WITH NOCHECK ADD 
	CONSTRAINT [PK_Payment] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Product] WITH NOCHECK ADD 
	CONSTRAINT [PK_Product] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[SystemBasicData] WITH NOCHECK ADD 
	CONSTRAINT [PK_SystemBasicData] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[SystemBasicDataDetail] WITH NOCHECK ADD 
	CONSTRAINT [PK_SystemBasicDataDetail] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[SystemDept] WITH NOCHECK ADD 
	CONSTRAINT [PK_SystemDept] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[SystemGroup] WITH NOCHECK ADD 
	CONSTRAINT [PK_SystemGroup] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[SystemLogInfo] WITH NOCHECK ADD 
	CONSTRAINT [PK_SystemLogInfo] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[SystemPopedom] WITH NOCHECK ADD 
	CONSTRAINT [PK_SystemPopedom] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[SystemRegion] WITH NOCHECK ADD 
	CONSTRAINT [PK_SystemRegion] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[SystemRole] WITH NOCHECK ADD 
	CONSTRAINT [PK_SystemRole] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[SystemUser] WITH NOCHECK ADD 
	CONSTRAINT [PK_SystemUser] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[WaterTicket] WITH NOCHECK ADD 
	CONSTRAINT [PK_WaterTicket] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

