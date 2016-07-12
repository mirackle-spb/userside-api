package pro.consultit.userside.api.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TariffListItem {

	private String id;
	private String name;
	private double payment;
	@JsonProperty("payment_interval")
	private int paymentInterval;
	private SpeedDescription speed;
	@JsonProperty("traffic")
	private long trafficIncluded;

	protected TariffListItem() {
	}

	public TariffListItem(String id, String name, double payment, int paymentInterval, SpeedDescription speed, long trafficIncluded) {
		this.id = id;
		this.name = name;
		this.payment = payment;
		this.paymentInterval = paymentInterval;
		this.speed = speed;
		this.trafficIncluded = trafficIncluded;
	}

	public String getId() {
		return id;
	}

	public TariffListItem setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TariffListItem setName(String name) {
		this.name = name;
		return this;
	}

	public double getPayment() {
		return payment;
	}

	public TariffListItem setPayment(double payment) {
		this.payment = payment;
		return this;
	}

	public int getPaymentInterval() {
		return paymentInterval;
	}

	public TariffListItem setPaymentInterval(int paymentInterval) {
		this.paymentInterval = paymentInterval;
		return this;
	}

	public SpeedDescription getSpeed() {
		return speed;
	}

	public TariffListItem setSpeed(SpeedDescription speed) {
		this.speed = speed;
		return this;
	}

	public long getTrafficIncluded() {
		return trafficIncluded;
	}

	public TariffListItem setTrafficIncluded(long trafficIncluded) {
		this.trafficIncluded = trafficIncluded;
		return this;
	}

	public static class SpeedDescription {
		private int up;
		private int down;

		protected SpeedDescription() {
		}

		public SpeedDescription(int up, int down) {
			this.up = up;
			this.down = down;
		}

		public int getUp() {
			return up;
		}

		public SpeedDescription setUp(int up) {
			this.up = up;
			return this;
		}

		public int getDown() {
			return down;
		}

		public SpeedDescription setDown(int down) {
			this.down = down;
			return this;
		}
	}

}
