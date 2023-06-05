// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    schoolList: null, //保存查询出来的 学校 对象集合
    banjiList: null, //保存查询出来的 班级 对象集合

    school: [],
    selectedSchool: '广东理工学院',
    schoolIndex: 0, //初始选中的项索引

    classList: [], //模拟后台查出来的班级列表
    classIndex: 0, //初始选中

    selectedClass: '软工1班',

    region: ['广东省', '肇庆市', '高要区'],
    sendText: '获取验证码',
    sendCss: 'link', //发短信按钮的初始样式

    miao: 59, //倒计时开始时间
    timer: null, //定时器

    realName: '', //保存用户的姓名

    Mobile: '', //保存用户手机号码

    Yzm: '', //保存用户填写的验证码

    sex: 'boy', //性别默认为男

    course: '前端开发', //课程默认方向
  },

  xz(e) {
    let i = e.detail.value //取得当前被选的项的索引（下标）
    this.setData({
      schoolIndex: i,
      selectedSchool: this.data.school[i]
    })
  },

  cl(e) {
    let i = e.detail.value
    this.setData({
      classIndex: i,
      selectedClass: this.data.classList[i]
    })
  },

  gp(e) {
    this.setData({
      region: e.detail.value
    })
  },

  send() {
    this.setData({
      sendCss: 'linked',
      sendText: '59秒后重新获取',
    })
    //开启定时器
    this.data.timer = setInterval(this.bian, 1000)

  },

  bian() {
    this.data.miao--
    if (this.data.miao < 1) {
      this.setData({
        miao: 59, //为下一次倒计时做准备
        sendCss: 'link', //恢复按钮的样式
        sendText: '获取验证码',
      })
      clearInterval(this.data.timer) //清除定时器
    } else {
      this.setData({
        sendText: this.data.miao + '秒后重新获取', //更新界面上的时间显示
      })
    }
  },

  setUsername(e) {
    //事件发生时，文本框中的内容在e对象中
    let value = e.detail.value
    // console.log(value);
    //保存到页面变量中
    this.setData({
      realName: value,
    })

  },

  setMobile(e) {
    let value = e.detail.value
    // console.log(value);
    this.setData({
      Mobile: value,
    })
  },

  setYzm(e) {
    let value = e.detail.value
    // console.log(value);
    this.setData({
      Yzm: value,
    })
  },

  setSex(e) {
    this.setData({
      sex: e.detail.value
    })
    // console.log('性别：' + this.data.sex)
  },

  setCourse(e) {
    this.setData({
      course: e.detail.value
    })
    // console.log('课程：' + this.data.course)
  },

  tankuang(msg) {
    wx.showToast({
      title: msg,
      icon: 'none',
    })
  },

  checkUsername() { //使用正则表达式检查中文
    let rge = /^[\u4e00-\u9fa5]{2,15}$/
    return rge.test(this.data.realName) //返回姓名的匹配结果
  },

  checkMobile() {
    let rge = /^1[3456789]\d{9}$/
    return rge.test(this.data.Mobile)
  },

  checkYzm() {
    let rge = /^[a-zA-Z0-9]{6}$/
    return rge.test(this.data.Yzm)
  },

  tijiao() {
    //检查用户名是否合法，不合法弹框提示，合法检查下一项
    if (!this.checkUsername()) {
      this.tankuang('姓名有误')
      return false
    }
    //检查手机号
    if (!this.checkMobile()) {
      this.tankuang('手机号不正确')
      return false
    }
    //检查验证码
    if (!this.checkYzm()) {
      this.tankuang('验证码错误')
      return false
    }
    //检查所有通过才能提交

    //提交
    this.tankuang('放行')
    this.print()

    this.post()
  },

  print() {
    console.log("姓名：" + this.data.realName);
    console.log("性别：" + this.data.sex);
    console.log("手机号：" + this.data.Mobile);
    console.log("验证码：" + this.data.Yzm);
    console.log("学校：" + this.data.school[this.data.schoolIndex]);
    console.log("班级：" + this.data.classList[this.data.classIndex]);
    console.log("课程：" + this.data.course);

    //10.60.159.126
  },

  post() {
    //发网络请求
    // let host = 'http://10.60.159.39:8080/ordan.com/user/add.mvc'
    let host = 'http://localhost:8080/ordan.com/user/add.mvc'

    // let host = 'http://10.60.159.126:8080/tiancai.com/user/add.do'

    wx.request({
      url: host,
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        // 'realname': this.data.realName,
        // 'mobile': this.data.Mobile,
        // 'yzm': this.data.Yzm,
        // 'school': this.data.school[this.data.schoolIndex],
        // 'banji': this.data.classList[this.data.classIndex],
        // 'course': this.data.course,
        // 'sex': this.data.sex,

        'realName': this.data.realName,
        'Mobile': this.data.Mobile,
        'Yzm': this.data.Yzm,
        'school': this.data.school[this.data.schoolIndex],
        'classList': this.data.classList[this.data.classIndex],
        'course': this.data.course,
        'sex': this.data.sex,

      },

      success: res => {
        let httpcode = res.statusCode //网络请求的http状态码
        if (httpcode == 200) {
          let code = res.data.code //业务状态码
          let msg = res.data.msg //业务处理完成后的消息

          if (code == 0) {
            this.tankuang('报名成功')
          } else {
            this.tankuang('报名失败：' + msg)
          }
        } else {
          this.tankuang('网络异常或服务器故障，请联系服务提供商')
        }
      }, //当调用成功后，服务器会把返回的结果送到res对象中
      // statusCode = 200
    })
  },

  onLoad() { //生命周期函数，当页面加载完成时，自动调用
    let url = 'http://localhost:8080/ordan.com/school/all.mvc'
    wx.request({
      url: url,
      method: 'GET',
      data: {},
      success: res => {
        // console.log("res=" + JSON.stringify(res));
        let list = res.data.list
        let temp = []
        for (let i = 0; i < list.length; i++) {
          temp.push(list[i].name)
        }
        this.setData({
          school: temp,
          schoolList: list
        })
        let sid = list[0].schoolid //得到第一个学校的id 以他为条件，查询所有班级
        this.findBySid(sid) //交给另一个函数去完成
      }
    })
  },

  findBySid(sid) {
    let url = 'http://localhost:8080/ordan.com/banji/sid.mvc'
    wx.request({
      url : url,
      method : 'GET',
      header : {},
      data: { 'sid' : sid },
      success : res => {
        // console.log("ban=" + JSON.stringify(res));
        let list = res.data.list
        let temp = []
        for (let i = 0; i < list.length; i++) {
          temp.push(list[i].name)
        }
        this.setData({
          classList: temp,
          banjiList: list
        })
      }
    })


  },

})