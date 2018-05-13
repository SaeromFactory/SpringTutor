package com.watchers.model;

import java.sql.Timestamp;

public class RawData {

	private Long id;
	private Long spinemid;
	private Long spinebase;
	private Long hipleft;
	private Long kneeleft;
	private Long kneeright;
	private Long ankleleft;
	private Long footleft;
	private Long footright;
	private Timestamp date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSpinemid() {
		return spinemid;
	}
	public void setSpinemid(Long spinemid) {
		this.spinemid = spinemid;
	}
	public Long getSpinebase() {
		return spinebase;
	}
	public void setSpinebase(Long spinebase) {
		this.spinebase = spinebase;
	}
	public Long getHipleft() {
		return hipleft;
	}
	public void setHipleft(Long hipleft) {
		this.hipleft = hipleft;
	}
	public Long getKneeleft() {
		return kneeleft;
	}
	public void setKneeleft(Long kneeleft) {
		this.kneeleft = kneeleft;
	}
	public Long getKneeright() {
		return kneeright;
	}
	public void setKneeright(Long kneeright) {
		this.kneeright = kneeright;
	}
	public Long getAnkleleft() {
		return ankleleft;
	}
	public void setAnkleleft(Long ankleleft) {
		this.ankleleft = ankleleft;
	}
	public Long getFootleft() {
		return footleft;
	}
	public void setFootleft(Long footleft) {
		this.footleft = footleft;
	}
	public Long getFootright() {
		return footright;
	}
	public void setFootright(Long footright) {
		this.footright = footright;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
