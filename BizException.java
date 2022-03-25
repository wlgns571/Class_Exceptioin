package java_day25;

public class BizException extends Exception {

	// 에러코드 만들기
	private String errCode = "";

	public BizException(String errCode, String errMsg) {
		super(errMsg);
		this.errCode = errCode;
	}

	@Override
	public String toString() {
		return "BizException [errCode=" + errCode + "]";
	}

	public BizException(String errMsg) {
		super(errMsg);
	}

	public BizException(Exception e) {
		super(e);
	}

	public String getErrCode() {
		return errCode;
	}

}
