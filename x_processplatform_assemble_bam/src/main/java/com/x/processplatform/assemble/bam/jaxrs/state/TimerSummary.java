package com.x.processplatform.assemble.bam.jaxrs.state;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.x.base.core.http.WrapOutMap;
import com.x.processplatform.assemble.bam.Business;
import com.x.processplatform.core.entity.content.Read;
import com.x.processplatform.core.entity.content.ReadCompleted;
import com.x.processplatform.core.entity.content.Task;
import com.x.processplatform.core.entity.content.TaskCompleted;
import com.x.processplatform.core.entity.content.TaskCompleted_;
import com.x.processplatform.core.entity.content.Task_;
import com.x.processplatform.core.entity.content.Work;
import com.x.processplatform.core.entity.content.WorkCompleted;
import com.x.processplatform.core.entity.content.WorkCompleted_;
import com.x.processplatform.core.entity.content.Work_;
import com.x.processplatform.core.entity.element.Application;
import com.x.processplatform.core.entity.element.Process;

public class TimerSummary extends ActionBase {
	public WrapOutMap execute(Business business) throws Exception {
		WrapOutMap wrap = new WrapOutMap();
		wrap.put("applicationCount", this.countApplication(business));
		wrap.put("processCount", this.countProcess(business));
		wrap.put("taskCount", this.countTask(business));
		wrap.put("taskCompletedCount", this.countTaskCompleted(business));
		wrap.put("readCount", this.countRead(business));
		wrap.put("readCompletedCount", this.countReadCompleted(business));
		wrap.put("workCount", this.countWork(business));
		wrap.put("workCompletedCount", this.countWorkCompleted(business));
		wrap.put("expiredTaskCount", this.countExpiredTask(business));
		wrap.put("expiredTaskCompletedCount", this.countExpiredTaskCompleted(business));
		wrap.put("expiredWorkCount", this.countExpiredWork(business));
		wrap.put("expiredWorkCompletedCount", this.countExpiredWorkCompleted(business));
		return wrap;
	}

	private Long countApplication(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(Application.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Application> root = cq.from(Application.class);
		cq.select(cb.count(root));
		return em.createQuery(cq).getSingleResult();
	}

	private Long countProcess(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(Process.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Process> root = cq.from(Process.class);
		cq.select(cb.count(root));
		return em.createQuery(cq).getSingleResult();
	}

	private Long countTask(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(Task.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Task> root = cq.from(Task.class);
		cq.select(cb.count(root));
		return em.createQuery(cq).getSingleResult();
	}

	private Long countTaskCompleted(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(TaskCompleted.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<TaskCompleted> root = cq.from(TaskCompleted.class);
		cq.select(cb.count(root));
		return em.createQuery(cq).getSingleResult();
	}

	private Long countRead(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(Read.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Read> root = cq.from(Read.class);
		cq.select(cb.count(root));
		return em.createQuery(cq).getSingleResult();
	}

	private Long countReadCompleted(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(ReadCompleted.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<ReadCompleted> root = cq.from(ReadCompleted.class);
		cq.select(cb.count(root));
		return em.createQuery(cq).getSingleResult();
	}

	private Long countWork(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(Work.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Work> root = cq.from(Work.class);
		cq.select(cb.count(root));
		return em.createQuery(cq).getSingleResult();
	}

	private Long countWorkCompleted(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(WorkCompleted.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<WorkCompleted> root = cq.from(WorkCompleted.class);
		cq.select(cb.count(root));
		return em.createQuery(cq).getSingleResult();
	}

	private Long countExpiredTask(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(Task.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Task> root = cq.from(Task.class);
		Predicate p = cb.lessThan(root.get(Task_.expireTime), new Date());
		cq.select(cb.count(root)).where(p);
		return em.createQuery(cq).getSingleResult();
	}

	private Long countExpiredTaskCompleted(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(TaskCompleted.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<TaskCompleted> root = cq.from(TaskCompleted.class);
		Predicate p = cb.equal(root.get(TaskCompleted_.expired), true);
		cq.select(cb.count(root)).where(p);
		return em.createQuery(cq).getSingleResult();
	}

	private Long countExpiredWork(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(Work.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Work> root = cq.from(Work.class);
		Predicate p = cb.lessThan(root.get(Work_.expireTime), new Date());
		cq.select(cb.count(root)).where(p);
		return em.createQuery(cq).getSingleResult();
	}

	private Long countExpiredWorkCompleted(Business business) throws Exception {
		EntityManager em = business.entityManagerContainer().get(WorkCompleted.class);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<WorkCompleted> root = cq.from(WorkCompleted.class);
		Predicate p = cb.equal(root.get(WorkCompleted_.expired), true);
		cq.select(cb.count(root)).where(p);
		return em.createQuery(cq).getSingleResult();
	}
}